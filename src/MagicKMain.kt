fun main(args: Array<String>){

    var deck = Deck()

    deck.shuffle()
    deck.reduceToTwentyOneCards()

    val stack1 = mutableListOf<Card>()
    val stack2 = mutableListOf<Card>()
    val stack3 = mutableListOf<Card>()

    for (i in 0..2) {
        run(deck, stack1, stack2, stack3)
    }

    print("Hmmmm, let me see... your card is ${showMeYourTrick(deck).toString()}")

}

fun displayCards(deck: Deck, stack1: MutableList<Card>, stack2: MutableList<Card>, stack3: MutableList<Card>) {
    var card1 = deck.pickFromTop()
    var card2 = deck.pickFromTop()
    var card3 = deck.pickFromTop()

    stack1.add(0, card1)
    stack2.add(0, card2)
    stack3.add(0, card3)

    println("${card1.toString()} ${card2.toString()} ${card3.toString()}")
}

fun joinStacks(deck: Deck, stack1: MutableList<Card>, stack2: MutableList<Card>, stack3: MutableList<Card>, chosenStack: Int) {
    when (chosenStack) {
        0 -> {
            stack2.addAll(stack1)
            stack2.addAll(stack3)
            deck.cards.clear()
            deck.cards.addAll(stack2)

            stack1.clear()
            stack2.clear()
            stack3.clear()
        }

        1 -> {
            stack1.addAll(stack2)
            stack1.addAll(stack3)
            deck.cards.clear()

            deck.cards.addAll(stack1)

            stack1.clear()
            stack2.clear()
            stack3.clear()
        }

        2 -> {
            stack2.addAll(stack3)
            stack2.addAll(stack1)
            deck.cards.clear()

            deck.cards.addAll(stack2)

            stack1.clear()
            stack2.clear()
            stack3.clear()
        }
    }
}

fun showMeYourTrick(deck: Deck): Card {
    for (i in 10 downTo 1) {
        deck.pickFromBottom()
    }

    return deck.pickFromBottom()
}

fun run(deck: Deck, stack1: MutableList<Card>, stack2: MutableList<Card>, stack3: MutableList<Card>) {
    //First run
    for (i in 0 until 20 step 3) {
        displayCards(deck, stack1, stack2, stack3)
    }

    println("Which stack contains your chosen card (1, 2 or 3)?")

    var chosenStack = readLine()!!.toInt().minus(1)

    joinStacks(deck, stack1, stack2, stack3, chosenStack)
}