package com.jizhe7550.kotlinapp.di.main

import com.jizhe7550.kotlinapp.ui.main.account.AccountFragment
import com.jizhe7550.kotlinapp.ui.main.account.ChangePasswordFragment
import com.jizhe7550.kotlinapp.ui.main.account.UpdateAccountFragment
import com.jizhe7550.kotlinapp.ui.main.blog.BlogFragment
import com.jizhe7550.kotlinapp.ui.main.blog.UpdateBlogFragment
import com.jizhe7550.kotlinapp.ui.main.blog.ViewBlogFragment
import com.jizhe7550.kotlinapp.ui.main.create_blog.CreateBlogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeBlogFragment(): BlogFragment

    @ContributesAndroidInjector()
    abstract fun contributeAccountFragment(): AccountFragment

    @ContributesAndroidInjector()
    abstract fun contributeChangePasswordFragment(): ChangePasswordFragment

    @ContributesAndroidInjector()
    abstract fun contributeCreateBlogFragment(): CreateBlogFragment

    @ContributesAndroidInjector()
    abstract fun contributeUpdateBlogFragment(): UpdateBlogFragment

    @ContributesAndroidInjector()
    abstract fun contributeViewBlogFragment(): ViewBlogFragment

    @ContributesAndroidInjector()
    abstract fun contributeUpdateAccountFragment(): UpdateAccountFragment
}