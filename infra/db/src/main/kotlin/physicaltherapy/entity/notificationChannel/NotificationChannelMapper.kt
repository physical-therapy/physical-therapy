package physicaltherapy.entity.notificationChannel

import org.mapstruct.Mapper
import physicaltherapy.config.BaseMapperConfig
import physicaltherapy.config.GenericMapper
import physicaltherapy.notificationChannel.NotificationChannel

@Mapper(config = BaseMapperConfig::class)
internal interface NotificationChannelMapper : GenericMapper<NotificationChannelEntity, NotificationChannel>
