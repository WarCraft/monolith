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

package gg.warcraft.monolith.api.core

import gg.warcraft.monolith.api.block.box.BlockBox
import gg.warcraft.monolith.api.entity.team.Team
import gg.warcraft.monolith.api.world.Direction

import java.time.{ZoneId, ZoneOffset}

case class MonolithConfig(
    buildRepository: BuildRepositoryConfig,
    database: DatabaseConfig,
    maintenanceMode: MaintenanceModeConfig,
    staffPermissions: StaffPermissionsConfig,
    teams: List[Team],
    // Miscellaneous
    baseHealth: Int,
    serverTimeZoneUtcOffset: String,
    shutdownMessage: String
) {
  val serverTimeZone: ZoneId = ZoneId.ofOffset(
    "UTC",
    ZoneOffset.of(serverTimeZoneUtcOffset)
  )
}

case class BuildRepositoryConfig(
    boundingBox: BlockBox,
    orientation: Direction
)

case class DatabaseConfig(
    embedded: Boolean,
    postgres: Option[PostgresConfig]
)

case class PostgresConfig(
    host: String,
    port: Int,
    database: String,
    user: String,
    password: String,
    poolSize: Int,
    ssl: Boolean
)

case class MaintenanceModeConfig(
    active: Boolean,
    permission: String
)

case class StaffPermissionsConfig(
    staff: String,
    mod: String,
    admin: String,
    dev: String
)
