package dev.insideyou
package yfp

final class IO[+A](val unsafeRun: () => A):
  def map[B](f: A => B): IO[B] =
    IO.delay(f(unsafeRun()))

  def flatMap[B](f: A => IO[B]): IO[B] =
    IO.delay(f(unsafeRun()).unsafeRun())

object IO:
  def delay[A](a: => A): IO[A] =
    IO(() => a)
