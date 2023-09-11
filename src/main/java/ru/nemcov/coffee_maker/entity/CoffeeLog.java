package ru.nemcov.coffee_maker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coffeeLogId;

    private Long coffeeId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "UTC")
    private Instant createDate;
}
