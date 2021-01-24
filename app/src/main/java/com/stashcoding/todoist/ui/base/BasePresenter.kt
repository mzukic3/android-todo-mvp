package com.stashcoding.todoist.ui.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BasePresenter<V> {
    protected var view: V? = null
    protected var compositeDisposable = CompositeDisposable()

    fun attachView(view: V) {
        this.view = view
    }

    fun detachView() {
        compositeDisposable.clear()
        this.view = null
    }

    /**
     * Kotlin extension function which adds Disposable object to CompositeDisposable
     * @receiver Disposable
     * @param disposable CompositeDisposable
     */
    fun Disposable.addToEventStream() {
        compositeDisposable.add(this)
    }
}
