package dev.insideyou
package yfp

final class Service(dependencies: Dependencies):
  def getCityName1(userId: UserId): IO[Maybe[String]] =
    for
      maybeUser <- dependencies.findUser(userId)
      maybeCity <- maybeUser.flatTraverse(user => dependencies.findCity(user.zipCode))
    yield maybeCity.map(city => city.name)

  def getCityName2(userId: UserId): IO[Maybe[String]] =
    dependencies.findUser(userId).flatMap { maybeUser =>
      maybeUser
        .flatTraverse { user =>
          dependencies.findCity(user.zipCode)
        }
        .map { maybeCity =>
          maybeCity.map(city => city.name)
        }
    }

  def getCityName3(userId: UserId): IO[Maybe[String]] =
    dependencies.findUser(userId).flatMap { maybeUser =>
      maybeUser.flatTraverse { user =>
        dependencies.findCity(user.zipCode).map { maybeCity =>
          maybeCity.map(city => city.name)
        }
      }
    }

  def getCityName4(userId: UserId): IO[Maybe[String]] =
    IO.delay {
      dependencies.findUser(userId).unsafeRun() match
        case Nothing => Nothing
        case Just(user) =>
          dependencies.findCity(user.zipCode).unsafeRun() match
            case Nothing => Nothing
            case Just(city) => Just(city.name)
    }
