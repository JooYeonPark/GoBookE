<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Druwa!</title>

<!-- Bootstrap -->
<link href="resource/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="resource/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="resource/css/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="resource/css/green.css" rel="stylesheet">
<!-- bootstrap-progressbar -->
<link href="resource/css/bootstrap-progressbar-3.3.4.min.css"
  rel="stylesheet">
<!-- JQVMap -->
<link href="resource/css/jqvmap.min.css" rel="stylesheet" />
<!-- bootstrap-daterangepicker -->
<link href="resource/css/daterangepicker.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="resource/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
  <div class="container body">
    <div class="main_container">
      <%@ include file="header/header.jspf"%>

      <!-- top navigation -->
      <div class="top_nav">
        <div class="nav_menu">
          <nav>
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>


          </nav>
        </div>
      </div>
      <!-- /top navigation -->

      <!-- page content -->
      <div class="right_col" role="main">

        <!--            코딩 부분                       -->
        <div class="row">
          <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
              <div class="x_title">
                <h2>회원가입</h2>
                <div class="clearfix"></div>
              </div>
              <div class="x_content">
                <form class="form-horizontal form-label-left"
                  action="memberRegister.do" method="post">
                  <!-- <span class="section">회원정보 등록</span> -->

                  <!-- <form class="form-horizontal form-label-left" novalidate>
									<span class="section">회원가입</span> -->

                  <br>
                  <p align="right">(*) 항목은 반드시 입력해 주세요.</p>
                  <br>

                  <div class="item form-group">
                    <label
                      class="control-label col-md-3 col-sm-3 col-xs-12"
                      for="name">아이디 <span class="required">(*)</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <input name="memberId" id="memberId"
                        class="form-control col-md-7 col-xs-12"
                        data-validate-length-range="6"
                        data-validate-words="2" required="required"
                        type="text">
                    </div>
                  </div>

                  <div class="item form-group">
                    <label
                      class="control-label col-md-3 col-sm-3 col-xs-12"
                      for="email">비밀번호 <span class="required">(*)</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <input type="password" name="password"
                        id="password" data-validate-linked="email"
                        required="required"
                        class="form-control col-md-7 col-xs-12">
                    </div>
                  </div>
                  <div class="item form-group">
                    <label
                      class="control-label col-md-3 col-sm-3 col-xs-12"
                      for="website">비밀번호 확인 <span
                      class="required">(*)</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <input type="password" id="password-confirm"
                        required="required"
                        class="form-control col-md-7 col-xs-12">
                    </div>
                  </div>
                  <div class="item form-group">
                    <label
                      class="control-label col-md-3 col-sm-3 col-xs-12"
                      for="occupation">이름 <span class="required">(*)</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <input type="text" name="name" id="name"
                        data-validate-length-range="5,20"
                        class="optional form-control col-md-7 col-xs-12">
                    </div>
                  </div>
                  <div class="item form-group">
                    <label
                      class="control-label col-md-3 col-sm-3 col-xs-12"
                      for="occupation">H.P <span
                      class="required">(*)</span></label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <input type="text" name="hp" id="hp"
                        data-validate-length="6,8"
                        class="form-control col-md-7 col-xs-12"
                        required="required">
                    </div>
                  </div>



                  <div class="item form-group">
                    <label for="password2"
                      class="control-label col-md-3 col-sm-3 col-xs-12">E-mail
                      <span class="required">(*)</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <input type="text" name="email" id="email"
                        data-validate-linked="password"
                        class="form-control col-md-7 col-xs-12"
                        required="required">
                    </div>
                  </div>
                  <div class="item form-group">
                    <label
                      class="control-label col-md-3 col-sm-3 col-xs-12"
                      for="telephone">주소검색 <span
                      class="required">(*)</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <div class=" col-md-12 col-sm-12 col-xs-12">
                        <input type="text"
                          class="XenoFindZip form-control"
                          placeholder="엔터를 누르면 검색됩니다." data-z="zip"
                          data-a="address">

                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <span class="XenoFindZipLabel"></span>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="item form-group">
                    <label
                      class="control-label col-md-3 col-sm-3 col-xs-12"
                      for="telephone">우편번호 <span
                      class="required">(*)</span></label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <input class="form-control col-md-7 col-xs-12"
                        required="required" type="text" name="zip">
                    </div>
                  </div>
                  <div class="item form-group">
                    <label
                      class="control-label col-md-3 col-sm-3 col-xs-12">주소
                      <span class="required">(*)</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <input class="form-control col-md-7 col-xs-12"
                        required="required" type="text" name="address">
                    </div>
                  </div>
                  <div class="item form-group">
                    <label
                      class="control-label col-md-3 col-sm-3 col-xs-12">상세주소
                      <span class="required">(*)</span>
                    </label>
                    <div class="col-md-6 col-sm-6 col-xs-12">
                      <input class="form-control col-md-7 col-xs-12"
                        required="required" type="text"
                        name="detailAddress">
                    </div>
                  </div>


                  <div class="ln_solid"></div>

                  <div class="form-group">
                    <div class="col-md-6 col-md-offset-3">


                      <input id="submit" type="submit"
                        class="btn btn-success" value="회원가입"> <a
                        href="index.jsp" class="btn btn-primary">취소</a>

                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
        <!--            코딩 부분                    -->
      </div>
      <!-- /page content -->

      <!-- footer content -->

      <!-- /footer content -->
    </div>
  </div>

  <!-- jquery 가 필요합니다. -->
  <script
    src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script
    src="//cdnjs.cloudflare.com/ajax/libs/jquery-migrate/1.2.1/jquery-migrate.min.js"></script>

  <!-- roadzip.min.js -->
  <!-- roadzip.min.js 을 이용하려면 jquery ui 가 필요합니다. -->
  <script
    src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
  <link rel="stylesheet"
    href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.min.css" />

  <!-- 구버전 IE 에 placeholder 지원 : https://code.google.com/p/jqueryplaceholder/ -->

  <!-- ssl 대응 됩니다. cdn 이용하듯 서버에 저장하지 말고 그대로 링크하세요.
		예고 없이 스크립트가 변경될 수 있으며, 저장할 경우 호환되지 않을 수 있습니다.
		이곳에 적혀 있는 이용방법대로만 이용해주세요. -->
  <link rel="stylesheet" href="//xenosi.de/load/roadzip/roadzip.css" />
  <script src="//xenosi.de/load/roadzip/roadzip.min.js"></script>

  <script>
			$(function() {
				$('input.XenoFindZip').each(XenoZipFinder); // input 에 검색스크립트 연결
			});
		</script>
  <!-- / roadzip.min.js -->

  <!-- roadzip.mobile.min.js -->
  <!-- roadzip.mobile.min.js 을 이용하려면 select2 가 필요합니다. http://ivaynberg.github.io/select2/ -->
  <link rel="stylesheet"
    href="//cdnjs.cloudflare.com/ajax/libs/select2/3.4.5/select2.min.css" />
  <script
    src="//cdnjs.cloudflare.com/ajax/libs/select2/3.4.5/select2.min.js"></script>

  <!-- ssl 대응 됩니다. cdn 이용하듯 서버에 저장하지 말고 그대로 링크하세요.
		예고 없이 스크립트가 변경될 수 있으며, 저장할 경우 호환되지 않을 수 있습니다.
		이곳에 적혀 있는 이용방법대로만 이용해주세요. -->
  <script src="//xenosi.de/load/roadzip/roadzip.mobile.min.js"></script>

  <script>
			$(function() {
				$('input.XenoFindZipMobile').each(XenoZipFinderMobile); // input 에 검색스크립트 연결
			});
		</script>
  <!-- / roadzip.mobile.min.js -->

  <!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
  <script>
			$(function() {
				$("#postcodify_search_button").postcodifyPopUp();
			});
		</script>

  <!-- jQuery -->
  <script src="resource/js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="resource/js/bootstrap.min.js"></script>
  <!-- FastClick -->
  <script src="resource/js/fastclick.js"></script>
  <!-- NProgress -->
  <script src="resource/js/nprogress.js"></script>
  <!-- Chart.js -->
  <script src="resource/js/Chart.min.js"></script>
  <!-- gauge.js -->
  <script src="resource/js/gauge.min.js"></script>
  <!-- bootstrap-progressbar -->
  <script src="resource/js/bootstrap-progressbar.min.js"></script>
  <!-- iCheck -->
  <script src="resource/js/icheck.min.js"></script>
  <!-- Skycons -->
  <script src="resource/js/skycons.js"></script>
  <!-- Flot -->
  <script src="resource/js/jquery.flot.js"></script>
  <script src="resource/js/jquery.flot.pie.js"></script>
  <script src="resource/js/jquery.flot.time.js"></script>
  <script src="resource/js/jquery.flot.stack.js"></script>
  <script src="resource/js/jquery.flot.resize.js"></script>
  <!-- Flot plugins -->
  <script src="resource/js/jquery.flot.orderBars.js"></script>
  <script src="resource/js/jquery.flot.spline.min.js"></script>
  <script src="resource/js/curvedLines.js"></script>
  <!-- DateJS -->
  <script src="resource/js/date.js"></script>
  <!-- JQVMap -->
  <script src="resource/js/jquery.vmap.js"></script>
  <script src="resource/js/jquery.vmap.world.js"></script>
  <script src="resource/js/jquery.vmap.sampledata.js"></script>
  <!-- bootstrap-daterangepicker -->
  <script src="resource/js/moment.min.js"></script>
  <script src="resource/js/daterangepicker.js"></script>

  <!-- Custom Theme Scripts -->
  <script src="resource/js/custom.min.js"></script>

  <!-- Flot -->
  <script>
			$(document)
					.ready(
							function() {
								var data1 = [ [ gd(2012, 1, 1), 17 ],
										[ gd(2012, 1, 2), 74 ],
										[ gd(2012, 1, 3), 6 ],
										[ gd(2012, 1, 4), 39 ],
										[ gd(2012, 1, 5), 20 ],
										[ gd(2012, 1, 6), 85 ],
										[ gd(2012, 1, 7), 7 ] ];

								var data2 = [ [ gd(2012, 1, 1), 82 ],
										[ gd(2012, 1, 2), 23 ],
										[ gd(2012, 1, 3), 66 ],
										[ gd(2012, 1, 4), 9 ],
										[ gd(2012, 1, 5), 119 ],
										[ gd(2012, 1, 6), 6 ],
										[ gd(2012, 1, 7), 9 ] ];
								$("#canvas_dahs").length
										&& $
												.plot(
														$("#canvas_dahs"),
														[ data1, data2 ],
														{
															series : {
																lines : {
																	show : false,
																	fill : true
																},
																splines : {
																	show : true,
																	tension : 0.4,
																	lineWidth : 1,
																	fill : 0.4
																},
																points : {
																	radius : 0,
																	show : true
																},
																shadowSize : 2
															},
															grid : {
																verticalLines : true,
																hoverable : true,
																clickable : true,
																tickColor : "#d5d5d5",
																borderWidth : 1,
																color : '#fff'
															},
															colors : [
																	"rgba(38, 185, 154, 0.38)",
																	"rgba(3, 88, 106, 0.38)" ],
															xaxis : {
																tickColor : "rgba(51, 51, 51, 0.06)",
																mode : "time",
																tickSize : [ 1,
																		"day" ],
																//tickLength: 10,
																axisLabel : "Date",
																axisLabelUseCanvas : true,
																axisLabelFontSizePixels : 12,
																axisLabelFontFamily : 'Verdana, Arial',
																axisLabelPadding : 10
															},
															yaxis : {
																ticks : 8,
																tickColor : "rgba(51, 51, 51, 0.06)",
															},
															tooltip : false
														});

								function gd(year, month, day) {
									return new Date(year, month - 1, day)
											.getTime();
								}
							});
		</script>
  <!-- /Flot -->

  <!-- JQVMap -->
  <script>
			$(document).ready(function() {
				$('#world-map-gdp').vectorMap({
					map : 'world_en',
					backgroundColor : null,
					color : '#ffffff',
					hoverOpacity : 0.7,
					selectedColor : '#666666',
					enableZoom : true,
					showTooltip : true,
					values : sample_data,
					scaleColors : [ '#E6F2F0', '#149B7E' ],
					normalizeFunction : 'polynomial'
				});
			});
		</script>
  <!-- /JQVMap -->

  <!-- Skycons -->
  <script>
			$(document).ready(
					function() {
						var icons = new Skycons({
							"color" : "#73879C"
						}), list = [ "clear-day", "clear-night",
								"partly-cloudy-day", "partly-cloudy-night",
								"cloudy", "rain", "sleet", "snow", "wind",
								"fog" ], i;

						for (i = list.length; i--;)
							icons.set(list[i], list[i]);

						icons.play();
					});
		</script>
  <!-- /Skycons -->

  <!-- Doughnut Chart -->
  <script>
			$(document).ready(
					function() {
						var options = {
							legend : false,
							responsive : false
						};

						new Chart(document.getElementById("canvas1"), {
							type : 'doughnut',
							tooltipFillColor : "rgba(51, 51, 51, 0.55)",
							data : {
								labels : [ "Symbian", "Blackberry", "Other",
										"Android", "IOS" ],
								datasets : [ {
									data : [ 15, 20, 30, 10, 30 ],
									backgroundColor : [ "#BDC3C7", "#9B59B6",
											"#E74C3C", "#26B99A", "#3498DB" ],
									hoverBackgroundColor : [ "#CFD4D8",
											"#B370CF", "#E95E4F", "#36CAAB",
											"#49A9EA" ]
								} ]
							},
							options : options
						});
					});
		</script>
  <!-- /Doughnut Chart -->

  <!-- bootstrap-daterangepicker -->
  <script>
			$(document)
					.ready(
							function() {

								var cb = function(start, end, label) {
									console.log(start.toISOString(), end
											.toISOString(), label);
									$('#reportrange span')
											.html(
													start
															.format('MMMM D, YYYY')
															+ ' - '
															+ end
																	.format('MMMM D, YYYY'));
								};

								var optionSet1 = {
									startDate : moment().subtract(29, 'days'),
									endDate : moment(),
									minDate : '01/01/2012',
									maxDate : '12/31/2015',
									dateLimit : {
										days : 60
									},
									showDropdowns : true,
									showWeekNumbers : true,
									timePicker : false,
									timePickerIncrement : 1,
									timePicker12Hour : true,
									ranges : {
										'Today' : [ moment(), moment() ],
										'Yesterday' : [
												moment().subtract(1, 'days'),
												moment().subtract(1, 'days') ],
										'Last 7 Days' : [
												moment().subtract(6, 'days'),
												moment() ],
										'Last 30 Days' : [
												moment().subtract(29, 'days'),
												moment() ],
										'This Month' : [
												moment().startOf('month'),
												moment().endOf('month') ],
										'Last Month' : [
												moment().subtract(1, 'month')
														.startOf('month'),
												moment().subtract(1, 'month')
														.endOf('month') ]
									},
									opens : 'left',
									buttonClasses : [ 'btn btn-default' ],
									applyClass : 'btn-small btn-primary',
									cancelClass : 'btn-small',
									format : 'MM/DD/YYYY',
									separator : ' to ',
									locale : {
										applyLabel : 'Submit',
										cancelLabel : 'Clear',
										fromLabel : 'From',
										toLabel : 'To',
										customRangeLabel : 'Custom',
										daysOfWeek : [ 'Su', 'Mo', 'Tu', 'We',
												'Th', 'Fr', 'Sa' ],
										monthNames : [ 'January', 'February',
												'March', 'April', 'May',
												'June', 'July', 'August',
												'September', 'October',
												'November', 'December' ],
										firstDay : 1
									}
								};
								$('#reportrange span').html(
										moment().subtract(29, 'days').format(
												'MMMM D, YYYY')
												+ ' - '
												+ moment().format(
														'MMMM D, YYYY'));
								$('#reportrange').daterangepicker(optionSet1,
										cb);
								$('#reportrange').on('show.daterangepicker',
										function() {
											console.log("show event fired");
										});
								$('#reportrange').on('hide.daterangepicker',
										function() {
											console.log("hide event fired");
										});
								$('#reportrange')
										.on(
												'apply.daterangepicker',
												function(ev, picker) {
													console
															.log("apply event fired, start/end dates are "
																	+ picker.startDate
																			.format('MMMM D, YYYY')
																	+ " to "
																	+ picker.endDate
																			.format('MMMM D, YYYY'));
												});
								$('#reportrange').on('cancel.daterangepicker',
										function(ev, picker) {
											console.log("cancel event fired");
										});
								$('#options1')
										.click(
												function() {
													$('#reportrange').data(
															'daterangepicker')
															.setOptions(
																	optionSet1,
																	cb);
												});
								$('#options2')
										.click(
												function() {
													$('#reportrange').data(
															'daterangepicker')
															.setOptions(
																	optionSet2,
																	cb);
												});
								$('#destroy')
										.click(
												function() {
													$('#reportrange').data(
															'daterangepicker')
															.remove();
												});
							});
		</script>
  <!-- /bootstrap-daterangepicker -->

  <!-- gauge.js -->
  <script>
			var opts = {
				lines : 12,
				angle : 0,
				lineWidth : 0.4,
				pointer : {
					length : 0.75,
					strokeWidth : 0.042,
					color : '#1D212A'
				},
				limitMax : 'false',
				colorStart : '#1ABC9C',
				colorStop : '#1ABC9C',
				strokeColor : '#F0F3F3',
				generateGradient : true
			};
			var target = document.getElementById('foo'), gauge = new Gauge(
					target).setOptions(opts);

			gauge.maxValue = 6000;
			gauge.animationSpeed = 32;
			gauge.set(3200);
			gauge.setTextField(document.getElementById("gauge-text"));
		</script>
  <!-- /gauge.js -->



  <script type="text/javascript">
			/*--------------------------------------------------------------------------
			 * 입력 중 검사
			 -------------------------------------------------------------------------*/

			// 아이디 검사
			$("#memberId")
					.keyup(
							function() {

								var memberId = document
										.getElementById("memberId").value;

								// 입력 여부 체크
								if (memberId == "") {
									$(".idError").remove();
									$(this)
											.after(
													"<p class='error idError'>필수 정보입니다.</p>")
								}
								// 문자 타입, 글자수 체크
								var isID = /^[a-z0-9][a-z0-9_\-]{3,19}$/;
								if (!isID.test(memberId)) {
									$(".idError").remove();
									$(this)
											.after(
													"<p class='error idError'>4자 이상의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.</p>")
									return false;
								}
								// 중복 체크
								$
										.ajax({
											type : 'POST',
											url : '/TeamMatching/memberIdCheck.do',
											data : {
												memberId : memberId
											},
											success : function(result) {
												if ($.trim(result) == "ok") {
													$(".idError").remove();
													$("#memberId")
															.after(
																	"<p class='error idError'>사용 가능한 ID 입니다.</p>")
												} else {
													$(".idError").remove();
													$("#memberId")
															.after(
																	"<p class='error idError'>사용 중인 ID 입니다.</p>")
												}
											}
										});
							});

			/*------------------------------------------------------------------------*/
			// 비밀번호 검사
			$("#password")
					.keyup(
							function() {

								var password = document
										.getElementById("password").value;

								$(".pwError").remove();

								// 입력 여부 체크
								if (password == "") {
									$(".pwError").remove();
									$(this)
											.after(
													"<p class='error pwError'>필수 정보입니다.</p>")
								}
								// 문자 타입 체크
								var isPW = /^[A-Za-z0-9`\-=\\\[\];',\./~!@#\$%\^&\*\(\)_\+|\{\}:"<>\?]{4,20}$/;
								if (!isPW.test(password)) {
									$(".pwError").remove();
									$(this)
											.after(
													"<p class='error pwError'>4~20자의  영문 대 소문자, 숫자, 특수문자를 사용하세요.</p>")
								}
							});

			/*------------------------------------------------------------------------*/
			// 비밀번호 확인
			$("#password-confirm")
					.keyup(
							function() {

								var password = document
										.getElementById("password").value;
								var password_confirm = document
										.getElementById("password-confirm").value;

								$(".pwcError").remove();

								// 입력 여부 체크
								if (password_confirm == "") {
									$(".pwcError").remove();
									$(this)
											.after(
													"<p class='error pwcError'>필수 정보입니다.</p>")
								}
								// 일치 여부 체크
								if (password != password_confirm) {
									$(".pwcError").remove();
									$(this)
											.after(
													"<p class='error pwcError'>비밀번호가 일치하지 않습니다.</p>")
								}
							});

			$("#email")
					.keyup(
							function() {

								var email = document.getElementById("email").value;
								var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

								$(".pwcError").remove();

								// 입력 여부 체크
								if (email == "") {
									$(".pwcError").remove();
									$(this)
											.after(
													"<p class='error pwcError'>필수 정보입니다.</p>")
								}

								// 입력 여부 체크
								if (regex.test(email) == false) {
									$(".pwcError").remove();
									$(this)
											.after(
													"<p class='error pwcError'>잘못된 이메일 형식입니다.</p>")
								}

							});
		</script>







</body>
</html>
