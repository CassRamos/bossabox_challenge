package com.cass.bossabox.dto;

import com.cass.bossabox.entity.Tools;

import java.util.List;

public record ToolsRequest(String title,
                           String link,
                           String description,
                           List<String> tags) {
    public Tools toModel() {
        return new Tools(title, link, description, tags);
    }

}
