package br.com.bootcampkotlin

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ContactHelperTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val sharedPreferences =
        context.getSharedPreferences("br.com.bootcampkotlin.PREFERENCES", Context.MODE_PRIVATE)
    private val contactHelper = ContactHelper(sharedPreferences)

    @Test
    fun `Quando chamar o metodo getListContacts() com 2 contatos, deve retornar uma lista de 2 contatos`() {
        // Prepara
        mockListaDoisContatos()

        // Valida
        val list = contactHelper.getListContacts()
        assertEquals(2, list.size)
    }

    @Test
    fun `Quando chamar o metodo getListContacts() sem contatos, deve retornar uma lista vazia`() {
        // Prepara
        mockListaContatosVazia()

        // Valida
        val list = contactHelper.getListContacts()
        assertEquals(0, list.size)
    }

    private fun mockListaDoisContatos() {
        contactHelper.setListContacts(
            arrayListOf(
                Contact(
                    "Igor Ferrani",
                    "(00) 0000-0000",
                    "img.jpg"
                ),
                Contact(
                    "Jose Alves",
                    "(99) 9999-9999",
                    "img.jpg"
                )
            )
        )
    }

    private fun mockListaContatosVazia() {
        contactHelper.setListContacts(arrayListOf())
    }
}
