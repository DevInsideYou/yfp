package dev.insideyou
package yfp

export Maybe.*

enum Maybe[+A]:
  case Just(a: A)
  case Nothing

  def fold[B](nothing: => B)(just: A => B): B =
    this match
      case Just(a) => just(a)
      case Nothing => nothing

  def map[B](f: A => B): Maybe[B] =
    fold(Nothing)(a => Just(f(a)))

  def flatMap[B](f: A => Maybe[B]): Maybe[B] =
    fold(Nothing)(f)

  def traverse[B](f: A => IO[B]): IO[Maybe[B]] =
    fold(IO.delay(Nothing))(a => f(a).map(b => Just(b)))

  def flatTraverse[B](f: A => IO[Maybe[B]]): IO[Maybe[B]] =
    fold(IO.delay(Nothing))(f)
