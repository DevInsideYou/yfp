package dev.insideyou
package yfp

@main def Main(args: String*): Unit =
  println("─" * 14)

  val userIds =
    Seq(-337, 700, 1337, 2500)

  for userId <- userIds yield println(service.getCityName1(userId).unsafeRun())

  println("─" * 14)

  for userId <- userIds yield println(service.getCityName2(userId).unsafeRun())

  println("─" * 14)

  for userId <- userIds yield println(service.getCityName3(userId).unsafeRun())

  println("─" * 14)

  for userId <- userIds yield println(service.getCityName4(userId).unsafeRun())

  println("─" * 14)
