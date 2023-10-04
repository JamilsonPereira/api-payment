package br.itau.payment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;


class PaymentServiceTest {
//
//    @InjectMocks
//    PaymentService paymentService;
//
//    @Mock
//    PaymentRequest requestDto;
//
//    @Mock
//    PaymentRepository paymentRepository;
//
//    @Mock
//    PaymentDomain model;
//
//    @Mock
//    PaymentResponse paymentResponse;
//
//    @Mock
//    MapperService mapperService;
//
//    @BeforeEach
//    void setUp() {
//        initMocks(this);
//        requestDto = new PaymentRequest();
//        char[][] matriz = {
//                {'A', 'O', 'S', 'O', 'A'},
//                {'A', 'R', 'Z', 'R', 'L'},
//                {'M', 'P', 'A', 'P', 'M'},
//                {'A', 'R', 'P', 'R', 'Z'},
//                {'B', 'O', 'E', 'R', 'A'}
//        };
//        requestDto.setMatriz(matriz);
//
//    }
//
//
//
//    @Test
//    void mapearPalindromosEVerificarSeValoresEstaoCorretos() {
//        String resultadoEsperado = "[aosoa, orpro, mpapm, arara]";
//
//        paymentService.mapearPalindromos(requestDto);
//        String resultado = paymentService.encontrarPalindromos(requestDto.getMatriz()).toString();
//        spy(paymentService).mapearPalindromos(requestDto);
//
//        assertEquals(resultadoEsperado, resultado);
//
//    }
//
//    @Test
//    void realizarBuscaDosPalindromosNaBaseDeDados() {
//        when(mapperService.mapperListDomainToListDto(Collections.singletonList(model)))
//                .thenReturn(Collections.singletonList(paymentResponse));
//        mapperService.mapperListDomainToListDto(Collections.singletonList(model));
//        paymentService.buscarPalindromosNaBaseDeDados().add(paymentResponse);
//        when(paymentService.buscarPalindromosNaBaseDeDados()).thenReturn(Collections.singletonList(paymentResponse));
//        spy(paymentService).buscarPalindromosNaBaseDeDados();
//    }
}