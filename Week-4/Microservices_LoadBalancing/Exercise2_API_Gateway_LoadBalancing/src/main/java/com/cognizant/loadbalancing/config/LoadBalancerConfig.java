package com.cognizant.loadbalancing.config;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Configuration
@LoadBalancerClient(name = "backend-service", configuration = LoadBalancerConfig.CustomLoadBalancerConfiguration.class)
public class LoadBalancerConfig {

    public static class CustomLoadBalancerConfiguration {

        @Bean
        public ReactorServiceInstanceLoadBalancer randomLoadBalancer(Environment environment, LoadBalancerClientFactory loadBalancerClientFactory) {
            String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
            return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
        }

        @Bean
        public ServiceInstanceListSupplier serviceInstanceListSupplier() {
            return new StaticServiceInstanceListSupplier("backend-service");
        }
    }

    public static class StaticServiceInstanceListSupplier implements ServiceInstanceListSupplier {

        private final String serviceId;

        public StaticServiceInstanceListSupplier(String serviceId) {
            this.serviceId = serviceId;
        }

        @Override
        public String getServiceId() {
            return serviceId;
        }

        @Override
        public Flux<List<ServiceInstance>> get() {
            return Flux.just(Arrays.asList(
                    new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8082, false),
                    new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8083, false)
            ));
        }
    }
}
