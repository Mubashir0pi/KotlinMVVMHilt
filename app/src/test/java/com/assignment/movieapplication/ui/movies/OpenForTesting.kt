
package com.assignment.movieapplication.ui.movies

@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class OpenClass


@OpenClass
@Target(AnnotationTarget.CLASS)
annotation class OpenForTesting