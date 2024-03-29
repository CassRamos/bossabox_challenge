package com.cass.bossabox.dto;

import java.util.List;

public record ToolsResponse(Long id,
                            String title,
                            String link,
                            String description,
                            List<String> tags) {
}
