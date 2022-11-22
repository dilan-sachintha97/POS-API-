package com.batch80.pointofsalebatch80.service.impl;

import com.batch80.pointofsalebatch80.dto.request.RequestSaveItemDTO;
import com.batch80.pointofsalebatch80.dto.response.ResponseSaveItemDTO;
import com.batch80.pointofsalebatch80.entity.Item;
import com.batch80.pointofsalebatch80.repo.ItemRepo;
import com.batch80.pointofsalebatch80.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;

@Service
public class ItemServiceIML implements ItemService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public ResponseSaveItemDTO saveItem(RequestSaveItemDTO requestSaveItemDTO) {
        Item item = modelMapper.map(requestSaveItemDTO,Item.class);
        item.setActiveState(true);  // default akath true

        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            ResponseSaveItemDTO itemDTO = modelMapper.map(item,ResponseSaveItemDTO.class);
            return itemDTO;
        }else {
            throw new KeyAlreadyExistsException("Already Exit");
        }
    }
}
