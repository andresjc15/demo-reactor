package com.ajcp.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Venta {

    private Integer id;
    private LocalDateTime fecha;

}
