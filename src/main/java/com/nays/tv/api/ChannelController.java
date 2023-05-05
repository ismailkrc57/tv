package com.nays.tv.api;

import com.nays.tv.models.Channel;
import com.nays.tv.repos.ChannelRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channels")
@RequiredArgsConstructor
@CrossOrigin
public class ChannelController {
    private final ChannelRepo channelRepo;

    @Value("${api.key}")
    public String apiKey;

    @GetMapping
    public ResponseEntity<List<Channel>> getChannels() {
        return ResponseEntity.ok(channelRepo.findAll());
    }

    @PostMapping
    public ResponseEntity<Channel> addChannel(@RequestBody Channel channel, @RequestParam String key) {
        if (!key.equals(apiKey)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(channelRepo.save(channel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChannel(@PathVariable Long id, @RequestParam String key) {
        if (!key.equals(apiKey)) {
            return ResponseEntity.badRequest().build();
        }
        channelRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Channel> updateChannel(@PathVariable Long id, @RequestBody Channel channel, @RequestParam String key) {
        if (!key.equals(apiKey)) {
            return ResponseEntity.badRequest().build();
        }
        Channel channelToUpdate = channelRepo.findById(id).orElseThrow();
        channelToUpdate.setName(channel.getName());
        channelToUpdate.setUrl(channel.getUrl());
        channelToUpdate.setImage(channel.getImage());
        return ResponseEntity.ok(channelRepo.save(channelToUpdate));
    }


}
