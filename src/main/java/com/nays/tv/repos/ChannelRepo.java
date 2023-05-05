package com.nays.tv.repos;

import com.nays.tv.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepo extends JpaRepository<Channel, Long> {

}
