package dev.insideyou
package yfp

val service =
  Service {
    new Dependencies:
      override def findUser(userId: UserId): IO[Maybe[User]] =
        IO.delay {
          if userId <= 0 then Nothing
          else if userId <= 1000 then Just(User(userId, zipCode = -123))
          else if userId <= 2000 then Just(User(userId, zipCode = 123))
          else Just(User(userId, zipCode = 1234))
        }

      override def findCity(zipCode: ZipCode): IO[Maybe[City]] =
        IO.delay {
          if zipCode <= 0 then Nothing
          else if zipCode <= 1000 then Just(City(zipCode, name = "Tokyo"))
          else Just(City(zipCode, name = "New York"))
        }
  }
