package com.nays.tv.api;

import com.nays.tv.models.Channel;
import com.nays.tv.repos.ChannelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channels")
@RequiredArgsConstructor
@CrossOrigin
public class ChannelController {
    private final ChannelRepo channelRepo;

    @GetMapping
    public ResponseEntity<List<Channel>> getChannels() {
        return ResponseEntity.ok(channelRepo.findAll());
    }

}
