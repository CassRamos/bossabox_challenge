package com.cass.bossabox.controller;

import com.cass.bossabox.dto.ToolsRequest;
import com.cass.bossabox.dto.ToolsResponse;
import com.cass.bossabox.entity.Tools;
import com.cass.bossabox.service.ToolsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    private final ToolsService toolsService;

    public ToolsController(ToolsService toolsService) {
        this.toolsService = toolsService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Tools> toolsList = toolsService.listAllTools();
        return ResponseEntity.ok().body(toolsList);
    }

    @GetMapping("/tag")
    public ResponseEntity findToolsByTag(@RequestParam String tags) {
        List<Tools> toolsList = toolsService.findToolByTag(tags);
        return ResponseEntity.ok().body(toolsList);
    }

    @PostMapping
    public ResponseEntity saveTools(@RequestBody ToolsRequest toolsRequest) {
        Tools toolsToBeSaved = toolsRequest.toModel();
        ToolsResponse toolsResponse = toolsService.saveTools(toolsToBeSaved);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(toolsResponse.id())
                .toUri();

        return ResponseEntity.created(headerLocation).body(toolsResponse);
    }

    @DeleteMapping
    public ResponseEntity deleteTools(@RequestParam long id) {
        toolsService.deleteToolsById(id);
        return ResponseEntity.ok().body("Tool deleted");
    }
}
