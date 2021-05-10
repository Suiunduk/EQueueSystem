package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Subscription;
import kg.inai.equeuesystem.models.SubscriptionModel;

import java.util.List;

public interface SubscriptionService {
    Subscription create(SubscriptionModel subscriptionModel);
    Subscription update(SubscriptionModel subscriptionModel);
    List<Subscription> findAll();
    Subscription getById(Long id);
}
