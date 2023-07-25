package com.crosenthal.libraryCalendar.elasticsearch.repository

import com.crosenthal.libraryCalendar.elasticsearch.ElasticsearchConfig
import com.crosenthal.libraryCalendar.elasticsearch.ElasticsearchProperties
import com.crosenthal.libraryCalendar.elasticsearch.domain.ScrapeIssues
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [ElasticsearchProperties::class, ElasticsearchConfig::class])
@EnableConfigurationProperties(ElasticsearchProperties::class)
class ScrapeIssuesRespositoryTest {

    @Autowired
    lateinit var repository: ScrapeIssuesRepository

    private val URL = "http://example.com/document.html"
    private val EVENT_SOURCE = "<div>the quick brown fox</div>"

    @BeforeEach
    fun setup() {
        repository.deleteAll()
    }

    @Test
    fun save() {
        assertThat(repository.findById(URL)).isEmpty

        val issue = ScrapeIssues(url = URL, eventSource = EVENT_SOURCE)
        repository.save(issue)

        val retrieved = repository.findById(URL)
        assertThat(retrieved).isNotEmpty
        assertThat(retrieved.get())
            .usingRecursiveComparison()
            .ignoringFields("timestamp")
            .isEqualTo(issue)
    }

}