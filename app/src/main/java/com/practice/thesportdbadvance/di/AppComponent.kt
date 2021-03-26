package com.practice.thesportdbadvance.di

import android.app.Application
import com.practice.thesportdbadvance.SportApplication
import com.practice.usecase.di.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        ViewModelFactoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent : AndroidInjector<SportApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}