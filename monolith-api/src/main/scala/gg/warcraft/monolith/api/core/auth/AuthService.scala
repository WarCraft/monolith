/*
 * MIT License
 *
 * Copyright (c) 2020 WarCraft <https://github.com/WarCraft>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package gg.warcraft.monolith.api.core.auth

import java.util.UUID

import gg.warcraft.monolith.api.core.{Message, MonolithConfig}

class AuthService(config: MonolithConfig) {
  private final val buildingOnMessage = Message.server("Building Mode: On")
  private final val buildingOffMessage = Message.server("Building Mode: Off")
  private final val moderatingOnMessage = Message.server("Moderating Mode: On")
  private final val moderatingOffMessage = Message.server("Moderating Mode: Off")
  private final val debuggingOnMessage = Message.server("Debugging Mode: On")
  private final val debuggingOffMessage = Message.server("Debugging Mode: Off")

  private val staffPermission: String = config.staffPermission
  private val modPermission: String = config.modPermission
  private val adminPermission: String = config.adminPermission
  private val devPermission: String = config.devPermission

  private var _building: Set[UUID] = Set.empty
  private var _moderating: Set[UUID] = Set.empty
  private var _debugging: Set[UUID] = Set.empty

  def isStaff(principal: Principal): Boolean =
    principal.hasPermission(staffPermission)

  def isMod(principal: Principal): Boolean =
    principal.hasPermission(modPermission)

  def isAdmin(principal: Principal): Boolean =
    principal.hasPermission(adminPermission)

  def isDev(principal: Principal): Boolean =
    principal.hasPermission(devPermission)

  def isBuilding(principal: Principal): Boolean =
    isStaff(principal) && _building.contains(principal.id)

  def isModerating(principal: Principal): Boolean =
    isMod(principal) && _moderating.contains(principal.id)

  def isDebugging(principal: Principal): Boolean =
    isDev(principal) && _debugging.contains(principal.id)

  private[auth] def toggleBuilding(principal: Principal): Unit =
    if (_building.contains(principal.id)) {
      _building -= principal.id
      principal.sendMessage(buildingOffMessage)
    } else {
      _building += principal.id
      principal.sendMessage(buildingOnMessage)
    }

  private[auth] def toggleModerating(principal: Principal): Unit =
    if (_moderating.contains(principal.id)) {
      _moderating -= principal.id
      principal.sendMessage(moderatingOffMessage)
    } else {
      _moderating += principal.id
      principal.sendMessage(moderatingOnMessage)
    }

  private[auth] def toggleDebugging(principal: Principal): Unit =
    if (_debugging.contains(principal.id)) {
      _debugging -= principal.id
      principal.sendMessage(debuggingOffMessage)
    } else {
      _debugging += principal.id
      principal.sendMessage(debuggingOnMessage)
    }
}
