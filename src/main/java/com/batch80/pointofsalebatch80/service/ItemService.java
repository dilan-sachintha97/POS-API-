package com.batch80.pointofsalebatch80.service;

import com.batch80.pointofsalebatch80.dto.request.RequestSaveItemDTO;
import com.batch80.pointofsalebatch80.dto.response.ResponseSaveItemDTO;

public interface ItemService {
    ResponseSaveItemDTO saveItem(RequestSaveItemDTO requestSaveItemDTO);
}
