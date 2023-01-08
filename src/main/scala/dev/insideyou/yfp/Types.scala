package dev.insideyou
package yfp

type UserId = Int
type ZipCode = Int
type CityName = String

final case class User(id: UserId, zipCode: ZipCode)
final case class City(zipCode: ZipCode, name: CityName)
