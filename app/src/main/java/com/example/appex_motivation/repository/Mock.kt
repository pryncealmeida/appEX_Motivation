package com.example.appex_motivation.repository

import com.example.appex_motivation.infra.MotivationConstants
import java.util.*

data class Phrase (val description: String, val category: Int)

class Mock {

    private val ALL = MotivationConstants.PHRASEFILTER.ALL
    private val SMILE = MotivationConstants.PHRASEFILTER.SMILE
    private val SUNNY = MotivationConstants.PHRASEFILTER.SUNNY

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", SMILE),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", SMILE),
        Phrase("Quando está mais escuro, vemos mais estrelas!", SMILE),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", SMILE),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", SMILE),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", SMILE),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", SUNNY),
        Phrase("Você perde todas as chances que você não aproveita.", SUNNY),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SUNNY),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", SUNNY),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", SUNNY),
        Phrase("Se você acredita, faz toda a diferença.", SUNNY),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SUNNY)
    )

    /**
     * Obtém frase aleatória de acordo com o filtro
     * */
    fun getPhrase(value: Int): String {



        val filtered = mListPhrases.filter { (it.category == value || value == ALL) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random().nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description

    }

}