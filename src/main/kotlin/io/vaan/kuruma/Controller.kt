package io.vaan.kuruma

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/cars")
class Controller {

    private val repository: MutableMap<Long, Kuruma> = mutableMapOf()
    private val logger: Logger = LoggerFactory.getLogger(Controller::class.java)

    @PostMapping
    fun create(@RequestBody kuruma: Kuruma) {
        logger.info("create $kuruma")
        repository[kuruma.id] = kuruma
    }

    @GetMapping
    fun findByFilter(
        @RequestParam numberOfWheels: Int?,
        @RequestParam color: String?
    ): Collection<Kuruma> {
        logger.info("findBy")

        val values = repository.values

        val filterByifNumberOfWheels =
            if (numberOfWheels != null) {
                values.filter { it.numberOfWheels == numberOfWheels }
            } else values

        val filterByColor =
            if (color != null) {
                filterByifNumberOfWheels.filter { it.color == color }
            } else filterByifNumberOfWheels

       return filterByColor
    }

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Long): Kuruma? {
        logger.info("findById $id")
        return repository[id]
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: Long) {
        logger.info("deleteById $id")
        repository.remove(id)
    }
}
