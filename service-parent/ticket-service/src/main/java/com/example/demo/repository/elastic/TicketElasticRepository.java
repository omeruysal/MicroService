package com.example.demo.repository.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.demo.model.elastic.TicketElasticModel;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketElasticModel, String>{

}
