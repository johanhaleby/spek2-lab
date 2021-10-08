/*
 *
 *  Copyright 2021 Johan Haleby
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package se.haleby.lab.spek2.rps

import java.time.ZonedDateTime
import java.util.*

@JvmInline
value class PlayerId(val value: UUID) {
    companion object {
        fun random() = PlayerId(UUID.randomUUID())
    }
}

@JvmInline
value class GameId(val value: UUID) {
    companion object {
        fun random() = GameId(UUID.randomUUID())
    }
}

@JvmInline
value class GameCreatorId(val value: UUID) {
    companion object {
        fun random() = GameCreatorId(UUID.randomUUID())
    }
}


@JvmInline
value class Timestamp(val value: ZonedDateTime) {
    companion object {
        fun now() = Timestamp(ZonedDateTime.now())
    }
}

enum class Shape {
    ROCK, PAPER, SCISSORS
}

@JvmInline
value class MaxNumberOfRounds private constructor(val value: Int) {

    companion object {
        val ONE = MaxNumberOfRounds(1)
        val THREE = MaxNumberOfRounds(3)
        val FIVE = MaxNumberOfRounds(5)
    }
}

@JvmInline
value class RoundNumber private constructor(val value: Int) {

    companion object {
        operator fun invoke(value: Int): RoundNumber {
            require(value > 0) {
                "${RoundNumber::class.simpleName} must be greater than 0"
            }
            return RoundNumber(value)
        }
    }
}

class GameCannotBeCreatedMoreThanOnce : IllegalArgumentException()
class GameDoesNotExist : IllegalArgumentException()
class CannotPlayHandBecauseGameEnded : IllegalArgumentException()
class CannotJoinTheGameTwice : IllegalArgumentException()
class GameAlreadyHasTwoPlayers : IllegalArgumentException()
class PlayerAlreadyPlayedInRound : IllegalArgumentException()