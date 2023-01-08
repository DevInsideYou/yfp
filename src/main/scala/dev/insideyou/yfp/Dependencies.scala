package dev.insideyou
package yfp

trait Dependencies:
  def findUser(id: UserId): IO[Maybe[User]]
  def findCity(code: ZipCode): IO[Maybe[City]]
