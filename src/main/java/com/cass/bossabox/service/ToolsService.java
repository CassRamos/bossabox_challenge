package com.cass.bossabox.service;

import com.cass.bossabox.dto.ToolsResponse;
import com.cass.bossabox.entity.Tools;
import com.cass.bossabox.repository.ToolsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsService {

    private final ToolsRepo toolsRepo;

    public ToolsService(ToolsRepo toolsRepo) {
        this.toolsRepo = toolsRepo;
    }

    public List<Tools> listAllTools() {
        return toolsRepo.findAll();
    }

    public List<Tools> findToolByTag(String tags) {
        return toolsRepo.findToolsByTag(tags);
    }

    public ToolsResponse saveTools(Tools tools) {
        var toolsSaved = toolsRepo.save(tools);
        return new ToolsResponse(
                toolsSaved.getId(),
                toolsSaved.getTitle(),
                toolsSaved.getLink(),
                toolsSaved.getDescription(),
                toolsSaved.getTags()
        );
    }

    public void deleteToolsById(Long id) {
        toolsRepo.deleteById(id);
    }

}
