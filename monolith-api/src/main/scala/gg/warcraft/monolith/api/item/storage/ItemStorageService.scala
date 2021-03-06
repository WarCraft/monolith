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

package gg.warcraft.monolith.api.item.storage

import java.util.UUID

import gg.warcraft.monolith.api.item.Item
import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._

import scala.concurrent.Future

class ItemStorageService {
  private final val emptyMap: Map[UUID, StoredItem] = Map.empty

  def getItems(playerId: UUID): Future[Iterable[StoredItem]] =
    ??? // TODO ItemStorageService.storage.getOrElse(playerId, emptyMap).values

  def storeItem[T <: Item](item: T, playerId: UUID): Future[UUID] =
    ???
//  {
//    val storedItem = StoredItem(
//      UUID.randomUUID(),
//      playerId,
//      item.asJson.noSpaces
//    )
//
//    val items = ItemStorageService.storage.getOrElse(playerId, emptyMap)
//    val newItems = items + (storedItem.id -> storedItem)
//    ItemStorageService.storage += (playerId -> newItems)
//
//    // TODO persist item
//
//    storedItem.id
//  }

  def claimItem(id: UUID, playerId: UUID): Future[Boolean] =
    ???
//  {
//    val json = ""
//    // TODO get item from persistence
//    // val item = decode[Item](json)
//
//    false
//  }
}




/*
public class ItemClaimTask implements Runnable {
    private final ItemStorageService itemStorageService;
    private final LegendsPlayerQueryService playerQueryService;
    private final LegendsPlayerCommandService playerCommandService;
    private final TaskService taskService;
    private final UUID playerId;

    public ItemClaimTask(ItemStorageService itemStorageService,
                         LegendsPlayerQueryService playerQueryService,
                         LegendsPlayerCommandService playerCommandService,
                         TaskService taskService,
                         UUID playerId) {
        this.itemStorageService = itemStorageService;
        this.playerQueryService = playerQueryService;
        this.playerCommandService = playerCommandService;
        this.taskService = taskService;
        this.playerId = playerId;
    }

    @Override
    public void run() {
        // TODO List<Item> storedItems = itemStorageService.getItems(playerId);
        List<Item> storedItems = new ArrayList<>();
        if (storedItems.isEmpty()) {
            return;
        }

        LegendsPlayer player = playerQueryService.getPlayer(playerId);
        if (!player.getInventory().hasSpace(1)) {
            playerCommandService.sendNotification(playerId,
                    "You don't have enough inventory space to claim all of your items. Please free up some space and try again.");
            return;
        }

        // TODO
//        Item itemToClaim = storedItems.get(0);
//        itemStorageService.claimItem(itemToClaim, playerId);
//        playerCommandService.giveItem(playerId, itemToClaim, false);
//        playerCommandService.sendNotification(playerId, "You received " + itemToClaim.getStackSize() +
//                " " + itemToClaim.getName() + "!");
//
//        taskService.runNextTick(this);
    }
}

 */