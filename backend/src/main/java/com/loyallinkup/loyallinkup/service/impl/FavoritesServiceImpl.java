package com.loyallinkup.loyallinkup.service.impl;

import com.loyallinkup.loyallinkup.model.Business;
import com.loyallinkup.loyallinkup.model.Client;
import com.loyallinkup.loyallinkup.model.Favorites;
import com.loyallinkup.loyallinkup.service.BusinessService;
import com.loyallinkup.loyallinkup.service.ClientService;
import org.springframework.stereotype.Service;
import com.loyallinkup.loyallinkup.repo.FavoritesRepo;
import com.loyallinkup.loyallinkup.service.FavoritesService;

import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    private final FavoritesRepo favoritesRepo;
    private final BusinessService businessService;
    private final ClientService clientService;

    public FavoritesServiceImpl(FavoritesRepo favoritesRepo, BusinessService businessService, ClientService clientService) {
        this.favoritesRepo = favoritesRepo;
        this.businessService = businessService;
        this.clientService = clientService;
    }

    @Override
    public Favorites create(Long business_id, Long client_id) {

        Business business = this.businessService.findById(business_id);
        Client client = this.clientService.findById(client_id).get();
        Favorites favorites = new Favorites(business,client);

        return this.favoritesRepo.save(favorites);
    }

    @Override
    public Boolean delete(Long favorites_id) {
        if(this.favoritesRepo.findById(favorites_id).isPresent()){
            this.favoritesRepo.deleteById(favorites_id);
            return true;
        }else
            return false;
    }

    @Override
    public Favorites edit(Long favorites_id, Long business_id, Long client_id) {
        Favorites favorites = this.favoritesRepo.findById(favorites_id).get();
        Business business = this.businessService.findById(business_id);
        Client client = this.clientService.findById(client_id).get();
        favorites.setBusiness(business);
        favorites.setClient(client);
        return this.favoritesRepo.save(favorites);
    }

    @Override
    public List<Favorites> listAll() {
        return this.favoritesRepo.findAll();
    }

    @Override
    public List<Favorites> listByBusinessId(Long business_id) {
        return this.favoritesRepo.findAllByBusinessId(business_id);
    }

    @Override
    public List<Favorites> listByClientId(Long client_id) {
        return this.favoritesRepo.findAllByClientId(client_id);
    }
}
