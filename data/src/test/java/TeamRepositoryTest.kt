import com.practice.data.model.APITeam
import com.practice.data.model.APITeamsResponse
import com.practice.data.network.SportService
import com.practice.data.repository.RetrofitTeamRepository
import com.practice.domain.model.Team
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class TeamRepositoryTest {

    private val sportService = mockk<SportService>()

    private val leagueParameter: String = "Spanish la league"

    private val apiTeam = APITeam(
        idTeam = "idTeam",
        strTeam = "strTeam",
        intFormedYear = "intFormedYear",
        strStadium = "strStadium"
    )

    private val apiTeamsResponse = APITeamsResponse(listOf(apiTeam))

    private val teamRepository = RetrofitTeamRepository(sportService)

    private val teamsExpected: List<Team> = apiTeamsResponse.apiTeams.map {
        it.apiTeamToTeam()
    }

    init {
        coEvery {
            sportService.getTeams(leagueParameter)
        } answers {
            apiTeamsResponse
        }
    }


    @Test
    fun `given a valid league name when getTeams is called then should get all teams`() {
        val teams: Flow<List<Team>> = teamRepository.getTeams(leagueParameter)

        runBlocking {
            Assert.assertEquals(teamsExpected, teams.single())
        }
    }
}