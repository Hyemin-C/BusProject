<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매안내</title>
<link rel="stylesheet" href="./css/infolist01.css" type="text/css">
</head>

<body>
	<div class="container">
		<section class="content">
			<main>

				<div>
					<div class="noti_top">
						<p class="noti">
							홈페이지를 통한 예매는<br> 당일 출발하는 차량의 출발시간 한 시간 이전까지 예매 가능합니다.
						</p>
						<p class="noti2">
							출발임박 차량의 온라인 예매를 원하시면 <a href="http://www.epassmobile.co.kr/">고속버스
								모바일앱</a>을 이용하여 주시기 바랍니다.
						</p>
					</div>

					<div>
						<div>
							<h3>승차권 예매/발권</h3>

							<ul>
								<li class="noti01"><br> 예매하신 승차권의 창구발권은 출발시<br> 간
									이전에 출발지 터미널에서 발권이<br> 가능하며 예매에 사용하신 신용카드를<br> 지참해주시기
									바랍니다.</li>
								<li class="noti02"><br> 예매에 사용하신 신용카드를 분실하고<br>
									신용카드 번호를 인지 못하신 경우에는<br> 승차권에 대한 어떠한 변경/취소 불가<br> 하오니
									주의하시기 바랍니다.</li>
								<li class="noti03"><br> 승차권 예매 서비스는 실시간으로 온라<br>
									인 처리가 되므로 예매 시 회선장애나<br> 기타 통신장애로 인하여 성공여부를 확<br> 인하지
									못하였을 경우 반드시 본 홈페<br> 이지의 <a
									href="https://www.kobus.co.kr/mrs/mrscfm.do"> 예매확인/취소/변경 </a>메뉴에서<br>
									성공여부를 확인하셔야 합니다.</li>
							</ul>

							<br>

							<ul>
								<li class="noti04"><br> 출발시간이 지난 후에는 승차권 발권이<br>
									불가합니다. 창구 발권 시 반드시 출발<br> 시간 이전에 터미널에 도착하셔서 발권<br>
									받으시기 바랍니다.</li>
								<li class="noti05"><br> 홈페이지의 ‘홈티켓’서비스를 이용해서<br>
									인쇄하시면 별도의 창구발권이 필요없<br> 습니다.</li>
								<li class="noti06"><br> 예매시 ‘모바일티켓’ 발권을 선택하시면<br>
									별도 발권절차 없이 고속버스 모바일앱<br> 으로 승차가 가능합니다.</li>
							</ul>
						</div>
						<div class="">
							<h3>수수료</h3>
							<p class="notib">승차권 예매를 취소하실 경우 출발일자를 기준으로 취소 수수료가 부과됩니다.</p>

							<div>
								<table>
									<caption>취소수수료</caption>

									<thead>
										<tr>
											<th>취소시기</th>
											<th>수수료</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td>예매 당일 또는 승차일 2일전 취소<br> (단, 당일출발차량 예매 후 1시간 이후
												취소는 수수료 발생)
											</td>
											<td>없음</td>
										</tr>
										<tr>
											<td>예매 후 출발일 1일 전일부터 지정차 출발 1시간 전 취소<br> (단, 당일출발차량
												예매 후 1시간 이내 취소는 수수료 없음)
											</td>
											<td>승차권 요금의 5%</td>
										</tr>
										<tr>
											<td>예매 후 지정차 출발 1시간 이내 취소<br> (단, 당일출발차량 예매 후 1시간
												이내 취소는 수수료 없음)
											</td>
											<td>승차권 요금의 10%</td>
										</tr>
										<tr>
											<td>예매하신 지정차 출발 후 목적지 도착예정시간 전 취소</td>
											<td>승차권 요금의 30%</td>
										</tr>
										<tr>
											<td>마일리지 구매 승차권 : 출발시간 이전 취소</td>
											<td>마일리지 100% 환급</td>
										</tr>
										<tr>
											<td>마일리지 구매 승차권 : 출발시간 이후 취소</td>
											<td>마일리지 100% 차감</td>
										</tr>
									</tbody>
								</table>
							</div>
							<p class="notib">
								승차권 예매내역을 변경할 경우 어떠한 수수료도 부과되지 않습니다. 변경은 시간/매수/등급 변경이 출발시간 1시간
								이전 1회에 한해서 가능합니다.<br>&nbsp 예매 사항의 변경 시 일자변경은 불가하오니 최초예매시
								주의하시기 바랍니다.
							</p>
							<p class="notib marginb">마일리지 구매 승차권은 시간변경이 불가하니 변경을 원하시면 취소
								후 다시 예매를 진행하시기 바랍니다.</p>

							<div class="epass_top">
								<h3>E-PASS 서비스</h3>
								<p class="notib">종이 승차권, 홈티켓, 모바일티켓 구분없이 승차와 동시에 셀프
									체크인(검표)가능합니다.</p>
								<p class="scheck">셀프 체크인 방법</p>
								<p class="noti2">
									고객이 소지한 승차권의 QR코드를 고속버스에 장착된 <span class="txt_epass">E-Pass
										단말기에 스캔</span>하고 탑승하세요.
								</p>
								<div class="self_check">
									<ul>
										<li class="epass01"><br>
											<p>승차권(종이)</p></li>
										<li class="epass02"><br>
											<p>홈티켓</p></li>
										<li class="epass03"><br>
											<p>모바일티켓</p></li>
									</ul>
								</div>
								<br> <br> <br> <br> <br> <br> <br>
								<br> <br> <br> <br> <br> <br> <br>

								<p class="notib">
									사전예매 없이도 시내버스 또는 지하철과 동일하게 교통카드 및 신용카드로 결제 후 탑승이 가능합니다. <span
										class="txt_epass">(버스에 빈좌석이 존재할 경우)</span>
								</p> <br> <br> <br>
								<div class="e_pass">
									<p class="card_tag">
										교통카드 태그 <span>(교통기능 내장 신용카드 포함)
										</span>
									</p>
								</div>

							</div>
						</div>
					</div>
				</div>
			</main>

		</section>
		<!-- <footer> -->

		<!-- </footer> -->
	</div>
	<br> <br> <br> <br> <br> <br>
</body>

</html>
