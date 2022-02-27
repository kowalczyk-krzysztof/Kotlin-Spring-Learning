package com.learningapp.learning

import org.springframework.data.mongodb.core.FindAndModifyOptions
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service
import kotlin.reflect.KClass



@Service
class SequenceService(val operations: MongoOperations) {

    fun next(documentType: KClass<*>) =
        operations.findAndModify(
            Query.query(Criteria.where("_id").`is`(documentType.simpleName?.lowercase())),
            Update().inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true),
           Sequence::class.java
        )?.seq ?: 1
}