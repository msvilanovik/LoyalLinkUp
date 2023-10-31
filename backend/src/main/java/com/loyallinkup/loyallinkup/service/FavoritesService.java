package com.loyallinkup.loyallinkup.service;

import com.loyallinkup.loyallinkup.model.Favorites;

import java.util.List;

public interface FavoritesService {

    Favorites create(Long business_id, Long client_id);

    Boolean delete(Long favorites_id);

    Favorites edit(Long favorites_id,Long business_id, Long client_id);

    List<Favorites> listAll();

    List<Favorites> listByBusinessId(Long business_id);

    List<Favorites> listByClientId(Long client_id);

}

