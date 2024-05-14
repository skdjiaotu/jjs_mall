package com.example.eurekaconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class UserData {
    Integer id;
    String name;
}
