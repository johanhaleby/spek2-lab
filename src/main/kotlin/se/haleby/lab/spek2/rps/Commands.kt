package se.haleby.lab.spek2.rps

// Commands
sealed interface GameCommand
data class CreateGame(val gameId: GameId, val timestamp: Timestamp, val creator: GameCreatorId, val maxNumberOfRounds: MaxNumberOfRounds) : GameCommand
data class PlayHand(val timestamp: Timestamp, val playerId: PlayerId, val shape: Shape) : GameCommand