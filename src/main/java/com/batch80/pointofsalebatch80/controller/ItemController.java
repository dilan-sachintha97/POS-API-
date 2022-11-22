package com.batch80.pointofsalebatch80.controller;

import com.batch80.pointofsalebatch80.dto.request.RequestSaveItemDTO;
import com.batch80.pointofsalebatch80.dto.response.ResponseSaveItemDTO;
import com.batch80.pointofsalebatch80.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = {"/save"})
    public ResponseSaveItemDTO saveItem(@RequestBody RequestSaveItemDTO requestSaveItemDTO){
        ResponseSaveItemDTO itemDTO = itemService.saveItem(requestSaveItemDTO);
        return itemDTO;
    }
}
