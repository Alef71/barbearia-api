package br.com.clubedosbarbas.barbeariaapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "RelatorioMensal")
@Table(name = "relatoriomensal", uniqueConstraints = @UniqueConstraint(columnNames = { "mes", "ano", "barbeiro_id" }))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioMensal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer mes;

    @Column(nullable = false)
    private Integer ano;

    @Column(name = "total_entradas", nullable = false)
    private BigDecimal totalEntradas;

    @Column(name = "total_despesas", nullable = false)
    private BigDecimal totalDespesas;

    @Column(nullable = false)
    private BigDecimal lucro;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id", nullable = false)
    private Barbeiro barbeiro;
}