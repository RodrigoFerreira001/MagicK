import java.lang.Exception
import java.util.stream.Collector

class Deck {
    var cards = mutableListOf<Card>()

    init {
        val suits = arrayListOf<String>("♥", "♦", "♣", "♠")
        val names = arrayListOf<String>("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")

        for (name in names) {
            for (suit in suits) {
                var card = Card(name, suit)
                cards.add(card)
            }
        }
    }

    override fun toString(): String {
        var result = StringBuilder("")

        for (card in cards) {
            result.append(card.toString() + "\n")
        }

        return result.toString()
    }

    fun reduceToTwentyOneCards() {
        if (cards.size < 21) {
            throw Exception("Número de cartas abaixo de 21")
        } else {
            cards = cards.subList(0, 21)
        }
    }

    fun shuffle () {
        cards.shuffle()
    }

    fun pickFromTop(): Card {
        val card = cards[0]
        cards.removeAt(0)
        return card
    }

    fun pickFromBottom(): Card {
        val card = cards[cards.size - 1]
        cards.removeAt(cards.size - 1)
        return card
    }
}