package com.crosenthal.libraryCalendar.elasticsearch.repository

import com.crosenthal.libraryCalendar.elasticsearch.domain.CalendarEvent
import com.crosenthal.libraryCalendar.elasticsearch.domain.ScrapeIssues
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface CalendarEventRepository : ElasticsearchRepository<CalendarEvent, String>