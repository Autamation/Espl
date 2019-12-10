<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"	crossorigin="anonymous">
	 -->
	<style type="text/css">
	
	.loader-div {
	margin: -170px 0 0 39%;
	border-radius: 2px; /* margin: 290px 0 0 50%;absolute relative */
	display: none;
	opacity: 1.0;
	position: absolute;
}
	
	</style>
	
<%-- <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script	src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> <script src="${pageContext.request.contextPath}/static/js/alert.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"	crossorigin="anonymous"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script> --%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/checkout.css"> 
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css"> --%>
<link href="${pageContext.request.contextPath}/static/css/alert.css" rel = "stylesheet">
<style>
</style>
</head>
<body>
	 <jsp:include page="header.jsp"></jsp:include>
 
	<div class="container">

		<button class="tablink" onclick="openPage('Home', this, 'black')"
			id="defaultOpen">
			<i class="fa fa-home" style="font-size: 24px"></i> Dashboard Home
		</button>
		<button class="tablink"
			onclick="openPage('Personaldetails', this, 'black')">
			<i class="fa fa-user" style="font-size: 24px;"></i>&nbsp;Personal
			Details
		</button>
		<button class="tablink" onclick="openPage('mplans', this, 'black')">
			<i class="fa fa-money" style="font-size: 24px"></i>&nbsp;My Plans
		</button>
		<button class="tablink" onclick="openPage('settings', this, 'black')">
			<i class="fa fa-cog fa-spin" style="font-size: 24px"></i>&nbsp;Settings
		</button>

		<div id="Home" class="tabcontent general-form">
    		<div class="tab-container">
     		 <h2>Welcome <c:out value="${username}"></c:out>!!</h2>
     		 
     		 
     		 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.

Why do we use it?
It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).


Where does it come from?
Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.

The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.

Where can I get some?
Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.

Why do we use it?
It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).




  		  </div>
		</div>



		<div id="Personaldetails" class="tabcontent general-form">

			<div class="tab-container">

				<h2>Your Details</h2>
				<div>
					<label for="clientaccount_name">First Name</label> <input
						type="text" id="clientaccount_name" name="clientaccount_name"
						value="${userDetails.firstName}">
				</div>
				<div>
					<label for="clientaccount_lname">Last Name</label> <input
						type="text" id="clientaccount_lname" name="clientaccount_lname"
						value="${userDetails.lastName}">
				</div>
				<div>
					<label for="clientaccount_email">Email</label> <input type="text"
						id="clientaccount_email" name="clientaccount_email" value="${userDetails.email}">
				</div>
				<div>
					<label for="clientaccount_company_name">Company Name</label> <input
						type="text" id="clientaccount_company_name"
						name="clientaccount_company_name" value="${userDetails.companyName}">
				</div>
				<div>
					<label for="clientaccount_job_title">Job Title</label>
					 
					<select id="clientaccount_job_title" name="clientaccount_job_title" required="required" >
						<c:choose>
							
							<c:when test="${userDetails.jobTitile} eq null}">
							  <option value="">SELECT</option>
							</c:when>
							
							<c:otherwise>
								<option value="${userDetails.jobTitile}">${userDetails.jobTitile}</option>
							</c:otherwise>
						
						</c:choose>
						<option value="">Best describe your role?</option>
						<option value="director">Director</option>
						<option value="business_owner">Business Owner</option>
						<option value="management">Management</option>
						<option value="senior_management">Senior Management</option>
						<option value="sales_business_development">Sales / Business Development</option>
						<option value="marketing_public_relations">Marketing &amp; Public Relations</option>
						<option value="administration">Administration</option>
						<option value="other">Other</option>
					</select>
				</div>

				<div>
					<label for="clientaccount_website">Website URL</label> <input
						type="text" id="clientaccount_website"
						name="clientaccount_website" placeholder="e.g. www.yourdomain.com"
						value="${userDetails.websiteUrl}">
				</div>

				<div>
					<label for="socialserver_corebundle_clientaccount_country"
						class="required">Country</label>
						<select id="socialserver_corebundle_clientaccount_country"
						name="socialserver_corebundle_clientaccount_country">
						
						<c:choose>
						<c:when test="${userDetails.country} eq null">
						
							<option value="">SELECT</option>
						</c:when>
						<c:otherwise>
						
						<option value="${userDetails.country}">${userDetails.country}</option>
						
						</c:otherwise>
	
						</c:choose>
						<option value="AF">Afghanistan</option>
						<option value="AX">Åland Islands</option>
						<option value="AL">Albania</option>
						<option value="DZ">Algeria</option>
						<option value="AS">American Samoa</option>
						<option value="AD">Andorra</option>
						<option value="AO">Angola</option>
						<option value="AI">Anguilla</option>
						<option value="AQ">Antarctica</option>
						<option value="AG">Antigua &amp; Barbuda</option>
						<option value="AR">Argentina</option>
						<option value="AM">Armenia</option>
						<option value="AW">Aruba</option>
						<option value="AC">Ascension Island</option>
						<option value="AU">Australia</option>
						<option value="AT">Austria</option>
						<option value="AZ">Azerbaijan</option>
						<option value="BS">Bahamas</option>
						<option value="BH">Bahrain</option>
						<option value="BD">Bangladesh</option>
						<option value="BB">Barbados</option>
						<option value="BY">Belarus</option>
						<option value="BE">Belgium</option>
						<option value="BZ">Belize</option>
						<option value="BJ">Benin</option>
						<option value="BM">Bermuda</option>
						<option value="BT">Bhutan</option>
						<option value="BO">Bolivia</option>
						<option value="BA">Bosnia &amp; Herzegovina</option>
						<option value="BW">Botswana</option>
						<option value="BR">Brazil</option>
						<option value="IO">British Indian Ocean Territory</option>
						<option value="VG">British Virgin Islands</option>
						<option value="BN">Brunei</option>
						<option value="BG">Bulgaria</option>
						<option value="BF">Burkina Faso</option>
						<option value="BI">Burundi</option>
						<option value="KH">Cambodia</option>
						<option value="CM">Cameroon</option>
						<option value="CA">Canada</option>
						<option value="IC">Canary Islands</option>
						<option value="CV">Cape Verde</option>
						<option value="BQ">Caribbean Netherlands</option>
						<option value="KY">Cayman Islands</option>
						<option value="CF">Central African Republic</option>
						<option value="EA">Ceuta &amp; Melilla</option>
						<option value="TD">Chad</option>
						<option value="CL">Chile</option>
						<option value="CN">China</option>
						<option value="CX">Christmas Island</option>
						<option value="CC">Cocos (Keeling) Islands</option>
						<option value="CO">Colombia</option>
						<option value="KM">Comoros</option>
						<option value="CG">Congo - Brazzaville</option>
						<option value="CD">Congo - Kinshasa</option>
						<option value="CK">Cook Islands</option>
						<option value="CR">Costa Rica</option>
						<option value="CI">Côte d’Ivoire</option>
						<option value="HR">Croatia</option>
						<option value="CU">Cuba</option>
						<option value="CW">Curaçao</option>
						<option value="CY">Cyprus</option>
						<option value="CZ">Czech Republic</option>
						<option value="DK">Denmark</option>
						<option value="DG">Diego Garcia</option>
						<option value="DJ">Djibouti</option>
						<option value="DM">Dominica</option>
						<option value="DO">Dominican Republic</option>
						<option value="EC">Ecuador</option>
						<option value="EG">Egypt</option>
						<option value="SV">El Salvador</option>
						<option value="GQ">Equatorial Guinea</option>
						<option value="ER">Eritrea</option>
						<option value="EE">Estonia</option>
						<option value="ET">Ethiopia</option>
						<option value="FK">Falkland Islands</option>
						<option value="FO">Faroe Islands</option>
						<option value="FJ">Fiji</option>
						<option value="FI">Finland</option>
						<option value="FR">France</option>
						<option value="GF">French Guiana</option>
						<option value="PF">French Polynesia</option>
						<option value="TF">French Southern Territories</option>
						<option value="GA">Gabon</option>
						<option value="GM">Gambia</option>
						<option value="GE">Georgia</option>
						<option value="DE">Germany</option>
						<option value="GH">Ghana</option>
						<option value="GI">Gibraltar</option>
						<option value="GR">Greece</option>
						<option value="GL">Greenland</option>
						<option value="GD">Grenada</option>
						<option value="GP">Guadeloupe</option>
						<option value="GU">Guam</option>
						<option value="GT">Guatemala</option>
						<option value="GG">Guernsey</option>
						<option value="GN">Guinea</option>
						<option value="GW">Guinea-Bissau</option>
						<option value="GY">Guyana</option>
						<option value="HT">Haiti</option>
						<option value="HN">Honduras</option>
						<option value="HK">Hong Kong SAR China</option>
						<option value="HU">Hungary</option>
						<option value="IS">Iceland</option>
						<option value="IN">India</option>
						<option value="ID">Indonesia</option>
						<option value="IR">Iran</option>
						<option value="IQ">Iraq</option>
						<option value="IE">Ireland</option>
						<option value="IM">Isle of Man</option>
						<option value="IL">Israel</option>
						<option value="IT">Italy</option>
						<option value="JM">Jamaica</option>
						<option value="JP">Japan</option>
						<option value="JE">Jersey</option>
						<option value="JO">Jordan</option>
						<option value="KZ">Kazakhstan</option>
						<option value="KE">Kenya</option>
						<option value="KI">Kiribati</option>
						<option value="XK">Kosovo</option>
						<option value="KW">Kuwait</option>
						<option value="KG">Kyrgyzstan</option>
						<option value="LA">Laos</option>
						<option value="LV">Latvia</option>
						<option value="LB">Lebanon</option>
						<option value="LS">Lesotho</option>
						<option value="LR">Liberia</option>
						<option value="LY">Libya</option>
						<option value="LI">Liechtenstein</option>
						<option value="LT">Lithuania</option>
						<option value="LU">Luxembourg</option>
						<option value="MO">Macau SAR China</option>
						<option value="MK">Macedonia</option>
						<option value="MG">Madagascar</option>
						<option value="MW">Malawi</option>
						<option value="MY">Malaysia</option>
						<option value="MV">Maldives</option>
						<option value="ML">Mali</option>
						<option value="MT">Malta</option>
						<option value="MH">Marshall Islands</option>
						<option value="MQ">Martinique</option>
						<option value="MR">Mauritania</option>
						<option value="MU">Mauritius</option>
						<option value="YT">Mayotte</option>
						<option value="MX">Mexico</option>
						<option value="FM">Micronesia</option>
						<option value="MD">Moldova</option>
						<option value="MC">Monaco</option>
						<option value="MN">Mongolia</option>
						<option value="ME">Montenegro</option>
						<option value="MS">Montserrat</option>
						<option value="MA">Morocco</option>
						<option value="MZ">Mozambique</option>
						<option value="MM">Myanmar (Burma)</option>
						<option value="NA">Namibia</option>
						<option value="NR">Nauru</option>
						<option value="NP">Nepal</option>
						<option value="NL">Netherlands</option>
						<option value="NC">New Caledonia</option>
						<option value="NZ">New Zealand</option>
						<option value="NI">Nicaragua</option>
						<option value="NE">Niger</option>
						<option value="NG">Nigeria</option>
						<option value="NU">Niue</option>
						<option value="NF">Norfolk Island</option>
						<option value="KP">North Korea</option>
						<option value="MP">Northern Mariana Islands</option>
						<option value="NO">Norway</option>
						<option value="OM">Oman</option>
						<option value="PK">Pakistan</option>
						<option value="PW">Palau</option>
						<option value="PS">Palestinian Territories</option>
						<option value="PA">Panama</option>
						<option value="PG">Papua New Guinea</option>
						<option value="PY">Paraguay</option>
						<option value="PE">Peru</option>
						<option value="PH">Philippines</option>
						<option value="PN">Pitcairn Islands</option>
						<option value="PL">Poland</option>
						<option value="PT">Portugal</option>
						<option value="PR">Puerto Rico</option>
						<option value="QA">Qatar</option>
						<option value="RE">Réunion</option>
						<option value="RO">Romania</option>
						<option value="RU">Russia</option>
						<option value="RW">Rwanda</option>
						<option value="WS">Samoa</option>
						<option value="SM">San Marino</option>
						<option value="ST">São Tomé &amp; Príncipe</option>
						<option value="SA">Saudi Arabia</option>
						<option value="SN">Senegal</option>
						<option value="RS">Serbia</option>
						<option value="SC">Seychelles</option>
						<option value="SL">Sierra Leone</option>
						<option value="SG">Singapore</option>
						<option value="SX">Sint Maarten</option>
						<option value="SK">Slovakia</option>
						<option value="SI">Slovenia</option>
						<option value="SB">Solomon Islands</option>
						<option value="SO">Somalia</option>
						<option value="ZA">South Africa</option>
						<option value="GS">South Georgia &amp; South Sandwich Islands</option>
						<option value="KR">South Korea</option>
						<option value="SS">South Sudan</option>
						<option value="ES">Spain</option>
						<option value="LK">Sri Lanka</option>
						<option value="BL">St. Barthélemy</option>
						<option value="SH">St. Helena</option>
						<option value="KN">St. Kitts &amp; Nevis</option>
						<option value="LC">St. Lucia</option>
						<option value="MF">St. Martin</option>
						<option value="PM">St. Pierre &amp; Miquelon</option>
						<option value="VC">St. Vincent &amp; Grenadines</option>
						<option value="SD">Sudan</option>
						<option value="SR">Suriname</option>
						<option value="SJ">Svalbard &amp; Jan Mayen</option>
						<option value="SZ">Swaziland</option>
						<option value="SE">Sweden</option>
						<option value="CH">Switzerland</option>
						<option value="SY">Syria</option>
						<option value="TW">Taiwan</option>
						<option value="TJ">Tajikistan</option>
						<option value="TZ">Tanzania</option>
						<option value="TH">Thailand</option>
						<option value="TL">Timor-Leste</option>
						<option value="TG">Togo</option>
						<option value="TK">Tokelau</option>
						<option value="TO">Tonga</option>
						<option value="TT">Trinidad &amp; Tobago</option>
						<option value="TA">Tristan da Cunha</option>
						<option value="TN">Tunisia</option>
						<option value="TR">Turkey</option>
						<option value="TM">Turkmenistan</option>
						<option value="TC">Turks &amp; Caicos Islands</option>
						<option value="TV">Tuvalu</option>
						<option value="UM">U.S. Outlying Islands</option>
						<option value="VI">U.S. Virgin Islands</option>
						<option value="UG">Uganda</option>
						<option value="UA">Ukraine</option>
						<option value="AE">United Arab Emirates</option>
						<option value="GB">United Kingdom</option>
						<option value="US">United States</option>
						<option value="UY">Uruguay</option>
						<option value="UZ">Uzbekistan</option>
						<option value="VU">Vanuatu</option>
						<option value="VA">Vatican City</option>
						<option value="VE">Venezuela</option>
						<option value="VN">Vietnam</option>
						<option value="WF">Wallis &amp; Futuna</option>
						<option value="EH">Western Sahara</option>
						<option value="YE">Yemen</option>
						<option value="ZM">Zambia</option>
						<option value="ZW">Zimbabwe</option></select>
				</div>

				<div>
					<label for="clientaccount_timezone" class="required">Time
						Zone</label> 
						
						<select id="clientaccount_timezone"
						name="clientaccount_timezone" required="required">
						
						<c:choose>
						
						 <c:when test="${userDetails.timeZone} eq null">
						     
						     <option value="">Please select...</option>
						 
						 </c:when>
						 
						 <c:otherwise>
						 
						 <option value="${userDetails.timeZone}">${userDetails.timeZone}</option>
						 
						 </c:otherwise>
						
						
						</c:choose>
						<option value="">Please select...</option>
						<option value="America/Adak">US/Adak</option>
						<option value="America/Anchorage">US/Anchorage</option>
						<option value="America/Boise">US/Boise</option>
						<option value="America/Chicago">US/Chicago</option>
						<option value="America/Denver">US/Denver</option>
						<option value="America/Detroit">US/Detroit</option>
						<option value="Pacific/Honolulu">US/Honolulu</option>
						<option value="America/Indiana/Indianapolis">US/Indiana/Indianapolis</option>
						<option value="America/Indiana/Knox">US/Indiana/Knox</option>
						<option value="America/Indiana/Marengo">US/Indiana/Marengo</option>
						<option value="America/Indiana/Petersburg">US/Indiana/Petersburg</option>
						<option value="America/Indiana/Tell_City">US/Indiana/Tell_City</option>
						<option value="America/Indiana/Vevay">US/Indiana/Vevay</option>
						<option value="America/Indiana/Vincennes">US/Indiana/Vincennes</option>

						<option value="America/Indiana/Winamac">US/Indiana/Winamac</option>
						<option value="America/Juneau">US/Juneau</option>
						<option value="America/Kentucky/Louisville">US/Kentucky/Louisville</option>
						<option value="America/Kentucky/Monticello">US/Kentucky/Monticello</option>
						<option value="America/Los_Angeles">US/Los_Angeles</option>
						<option value="America/Menominee">US/Menominee</option>
						<option value="America/Metlakatla">US/Metlakatla</option>
						<option value="America/New_York">US/New_York</option>
						<option value="America/Nome">US/Nome</option>
						<option value="America/North_Dakota/Beulah">US/North_Dakota/Beulah</option>
						<option value="America/North_Dakota/Center">US/North_Dakota/Center</option>
						<option value="America/North_Dakota/New_Salem">US/North_Dakota/New_Salem</option>
						<option value="America/Phoenix">US/Phoenix</option>
						<option value="America/Shiprock">US/Shiprock</option>
						<option value="America/Sitka">US/Sitka</option>
						<option value="America/Yakutat">US/Yakutat</option>
						<option value="America/Atikokan">Canada/Atikokan</option>
						<option value="America/Blanc-Sablon">Canada/Blanc-Sablon</option>
						<option value="America/Cambridge_Bay">Canada/Cambridge_Bay</option>
						<option value="America/Creston">Canada/Creston</option>
						<option value="America/Dawson">Canada/Dawson</option>
						<option value="America/Dawson_Creek">Canada/Dawson_Creek</option>
						<option value="America/Edmonton">Canada/Edmonton</option>
						<option value="America/Glace_Bay">Canada/Glace_Bay</option>
						<option value="America/Goose_Bay">Canada/Goose_Bay</option>
						<option value="America/Halifax">Canada/Halifax</option>
						<option value="America/Inuvik">Canada/Inuvik</option>
						<option value="America/Iqaluit">Canada/Iqaluit</option>
						<option value="America/Moncton">Canada/Moncton</option>
						<option value="America/Montreal">Canada/Montreal</option>
						<option value="America/Nipigon">Canada/Nipigon</option>
						<option value="America/Pangnirtung">Canada/Pangnirtung</option>
						<option value="America/Rainy_River">Canada/Rainy_River</option>
						<option value="America/Rankin_Inlet">Canada/Rankin_Inlet</option>
						<option value="America/Regina">Canada/Regina</option>
						<option value="America/Resolute">Canada/Resolute</option>
						<option value="America/St_Johns">Canada/St_Johns</option>
						<option value="America/Swift_Current">Canada/Swift_Current</option>
						<option value="America/Thunder_Bay">Canada/Thunder_Bay</option>
						<option value="America/Toronto">Canada/Toronto</option>
						<option value="America/Vancouver">Canada/Vancouver</option>
						<option value="America/Whitehorse">Canada/Whitehorse</option>
						<option value="America/Winnipeg">Canada/Winnipeg</option>
						<option value="America/Yellowknife">Canada/Yellowknife</option>
						<option value="Pacific/Midway">(GMT-11) Pacific/Midway</option>
						<option value="Pacific/Niue">(GMT-11) Pacific/Niue</option>
						<option value="Pacific/Pago_Pago">(GMT-11) Pacific/Pago_Pago</option>
						<option value="Pacific/Johnston">(GMT-10) Pacific/Johnston</option>
						<option value="Pacific/Rarotonga">(GMT-10) Pacific/Rarotonga</option>
						<option value="Pacific/Tahiti">(GMT-10) Pacific/Tahiti</option>
						<option value="Pacific/Marquesas">(GMT-9.5) Pacific/Marquesas</option>
						<option value="Pacific/Gambier">(GMT-9) Pacific/Gambier</option>
						<option value="America/Santa_Isabel">(GMT-8) America/Santa_Isabel</option>
						<option value="America/Tijuana">(GMT-8) America/Tijuana</option>
						<option value="Pacific/Pitcairn">(GMT-8) Pacific/Pitcairn</option>
						<option value="America/Chihuahua">(GMT-7) America/Chihuahua</option>
						<option value="America/Hermosillo">(GMT-7) America/Hermosillo</option>
						<option value="America/Mazatlan">(GMT-7) America/Mazatlan</option>
						<option value="America/Ojinaga">(GMT-7) America/Ojinaga</option>
						<option value="America/Bahia_Banderas">(GMT-6) America/Bahia_Banderas</option>
						<option value="America/Belize">(GMT-6) America/Belize</option>
						<option value="America/Cancun">(GMT-6) America/Cancun</option>
						<option value="America/Costa_Rica">(GMT-6) America/Costa_Rica</option>
						<option value="America/El_Salvador">(GMT-6) America/El_Salvador</option>
						<option value="America/Guatemala">(GMT-6) America/Guatemala</option>
						<option value="America/Managua">(GMT-6) America/Managua</option>
						<option value="America/Matamoros">(GMT-6) America/Matamoros</option>
						<option value="America/Merida">(GMT-6) America/Merida</option>
						<option value="America/Mexico_City">(GMT-6) America/Mexico_City</option>
						<option value="America/Monterrey">(GMT-6) America/Monterrey</option>
						<option value="America/Tegucigalpa">(GMT-6) America/Tegucigalpa</option>
						<option value="Pacific/Easter">(GMT-6) Pacific/Easter</option>
						<option value="Pacific/Galapagos">(GMT-6) Pacific/Galapagos</option>
						<option value="America/Bogota">(GMT-5) America/Bogota</option>
						<option value="America/Cayman">(GMT-5) America/Cayman</option>
						<option value="America/Grand_Turk">(GMT-5) America/Grand_Turk</option>
						<option value="America/Guayaquil">(GMT-5) America/Guayaquil</option>
						<option value="America/Havana">(GMT-5) America/Havana</option>
						<option value="America/Jamaica">(GMT-5) America/Jamaica</option>
						<option value="America/Lima">(GMT-5) America/Lima</option>
						<option value="America/Nassau">(GMT-5) America/Nassau</option>
						<option value="America/Panama">(GMT-5) America/Panama</option>
						<option value="America/Port-au-Prince">(GMT-5) America/Port-au-Prince</option>
						<option value="America/Caracas">(GMT-4.5) America/Caracas</option>
						<option value="America/Anguilla">(GMT-4) America/Anguilla</option>
						<option value="America/Antigua">(GMT-4) America/Antigua</option>
						<option value="America/Argentina/San_Luis">(GMT-4) America/Argentina/San_Luis</option>
						<option value="America/Aruba">(GMT-4) America/Aruba</option>
						<option value="America/Asuncion">(GMT-4) America/Asuncion</option>
						<option value="America/Barbados">(GMT-4) America/Barbados</option>
						<option value="America/Boa_Vista">(GMT-4) America/Boa_Vista</option>
						<option value="America/Campo_Grande">(GMT-4) America/Campo_Grande</option>
						<option value="America/Cuiaba">(GMT-4) America/Cuiaba</option>
						<option value="America/Curacao">(GMT-4) America/Curacao</option>
						<option value="America/Dominica">(GMT-4) America/Dominica</option>
						<option value="America/Eirunepe">(GMT-4) America/Eirunepe</option>
						<option value="America/Grenada">(GMT-4) America/Grenada</option>
						<option value="America/Guadeloupe">(GMT-4) America/Guadeloupe</option>
						<option value="America/Guyana">(GMT-4) America/Guyana</option>
						<option value="America/Kralendijk">(GMT-4) America/Kralendijk</option>
						<option value="America/La_Paz">(GMT-4) America/La_Paz</option>
						<option value="America/Lower_Princes">(GMT-4) America/Lower_Princes</option>
						<option value="America/Manaus">(GMT-4) America/Manaus</option>
						<option value="America/Marigot">(GMT-4) America/Marigot</option>
						<option value="America/Martinique">(GMT-4) America/Martinique</option>
						<option value="America/Montserrat">(GMT-4) America/Montserrat</option>
						<option value="America/Port_of_Spain">(GMT-4) America/Port_of_Spain</option>
						<option value="America/Porto_Velho">(GMT-4) America/Porto_Velho</option>
						<option value="America/Puerto_Rico">(GMT-4) America/Puerto_Rico</option>
						<option value="America/Rio_Branco">(GMT-4) America/Rio_Branco</option>
						<option value="America/Santiago">(GMT-4) America/Santiago</option>
						<option value="America/Santo_Domingo">(GMT-4) America/Santo_Domingo</option>
						<option value="America/St_Barthelemy">(GMT-4) America/St_Barthelemy</option>
						<option value="America/St_Kitts">(GMT-4) America/St_Kitts</option>
						<option value="America/St_Lucia">(GMT-4) America/St_Lucia</option>
						<option value="America/St_Thomas">(GMT-4) America/St_Thomas</option>
						<option value="America/St_Vincent">(GMT-4) America/St_Vincent</option>
						<option value="America/Thule">(GMT-4) America/Thule</option>
						<option value="America/Tortola">(GMT-4) America/Tortola</option>
						<option value="Antarctica/Palmer">(GMT-4) Antarctica/Palmer</option>
						<option value="Atlantic/Bermuda">(GMT-4) Atlantic/Bermuda</option>
						<option value="America/Araguaina">(GMT-3) America/Araguaina</option>
						<option value="America/Argentina/Buenos_Aires">(GMT-3) America/Argentina/Buenos_Aires</option>
						<option value="America/Argentina/Catamarca">(GMT-3) America/Argentina/Catamarca</option>
						<option value="America/Argentina/Cordoba">(GMT-3) America/Argentina/Cordoba</option>
						<option value="America/Argentina/Jujuy">(GMT-3) America/Argentina/Jujuy</option>
						<option value="America/Argentina/La_Rioja">(GMT-3) America/Argentina/La_Rioja</option>
						<option value="America/Argentina/Mendoza">(GMT-3) America/Argentina/Mendoza</option>
						<option value="America/Argentina/Rio_Gallegos">(GMT-3) America/Argentina/Rio_Gallegos</option>
						<option value="America/Argentina/Salta">(GMT-3) America/Argentina/Salta</option>
						<option value="America/Argentina/San_Juan">(GMT-3) America/Argentina/San_Juan</option>
						<option value="America/Argentina/Tucuman">(GMT-3) America/Argentina/Tucuman</option>
						<option value="America/Argentina/Ushuaia">(GMT-3) America/Argentina/Ushuaia</option>
						<option value="America/Bahia">(GMT-3) America/Bahia</option>
						<option value="America/Belem">(GMT-3) America/Belem</option>
						<option value="America/Cayenne">(GMT-3) America/Cayenne</option>
						<option value="America/Fortaleza">(GMT-3) America/Fortaleza</option>
						<option value="America/Godthab">(GMT-3) America/Godthab</option>
						<option value="America/Maceio">(GMT-3) America/Maceio</option>
						<option value="America/Miquelon">(GMT-3) America/Miquelon</option>
						<option value="America/Montevideo">(GMT-3) America/Montevideo</option>
						<option value="America/Paramaribo">(GMT-3) America/Paramaribo</option>
						<option value="America/Recife">(GMT-3) America/Recife</option>
						<option value="America/Santarem">(GMT-3) America/Santarem</option>
						<option value="America/Sao_Paulo">(GMT-3) America/Sao_Paulo</option>
						<option value="Antarctica/Rothera">(GMT-3) Antarctica/Rothera</option>
						<option value="Atlantic/Stanley">(GMT-3) Atlantic/Stanley</option>
						<option value="America/Noronha">(GMT-2) America/Noronha</option>
						<option value="Atlantic/South_Georgia">(GMT-2) Atlantic/South_Georgia</option>
						<option value="America/Scoresbysund">(GMT-1) America/Scoresbysund</option>
						<option value="Atlantic/Azores">(GMT-1) Atlantic/Azores</option>
						<option value="Atlantic/Cape_Verde">(GMT-1) Atlantic/Cape_Verde</option>
						<option value="Africa/Abidjan">(GMT+0) Africa/Abidjan</option>
						<option value="Africa/Accra">(GMT+0) Africa/Accra</option>
						<option value="Africa/Bamako">(GMT+0) Africa/Bamako</option>
						<option value="Africa/Banjul">(GMT+0) Africa/Banjul</option>
						<option value="Africa/Bissau">(GMT+0) Africa/Bissau</option>
						<option value="Africa/Casablanca">(GMT+0) Africa/Casablanca</option>
						<option value="Africa/Conakry">(GMT+0) Africa/Conakry</option>
						<option value="Africa/Dakar">(GMT+0) Africa/Dakar</option>
						<option value="Africa/El_Aaiun">(GMT+0) Africa/El_Aaiun</option>
						<option value="Africa/Freetown">(GMT+0) Africa/Freetown</option>
						<option value="Africa/Lome">(GMT+0) Africa/Lome</option>
						<option value="Africa/Monrovia">(GMT+0) Africa/Monrovia</option>
						<option value="Africa/Nouakchott">(GMT+0) Africa/Nouakchott</option>
						<option value="Africa/Ouagadougou">(GMT+0) Africa/Ouagadougou</option>
						<option value="Africa/Sao_Tome">(GMT+0) Africa/Sao_Tome</option>
						<option value="America/Danmarkshavn">(GMT+0) America/Danmarkshavn</option>
						<option value="Atlantic/Canary">(GMT+0) Atlantic/Canary</option>
						<option value="Atlantic/Faroe">(GMT+0) Atlantic/Faroe</option>
						<option value="Atlantic/Madeira">(GMT+0) Atlantic/Madeira</option>
						<option value="Atlantic/Reykjavik">(GMT+0) Atlantic/Reykjavik</option>
						<option value="Atlantic/St_Helena">(GMT+0) Atlantic/St_Helena</option>
						<option value="Europe/Dublin">(GMT+0) Europe/Dublin</option>
						<option value="Europe/Guernsey">(GMT+0) Europe/Guernsey</option>
						<option value="Europe/Isle_of_Man">(GMT+0) Europe/Isle_of_Man</option>
						<option value="Europe/Jersey">(GMT+0) Europe/Jersey</option>
						<option value="Europe/Lisbon">(GMT+0) Europe/Lisbon</option>
						<option value="Europe/London">(GMT+0) Europe/London</option>
						<option value="Africa/Algiers">(GMT+1) Africa/Algiers</option>
						<option value="Africa/Bangui">(GMT+1) Africa/Bangui</option>
						<option value="Africa/Brazzaville">(GMT+1) Africa/Brazzaville</option>
						<option value="Africa/Ceuta">(GMT+1) Africa/Ceuta</option>
						<option value="Africa/Douala">(GMT+1) Africa/Douala</option>
						<option value="Africa/Kinshasa">(GMT+1) Africa/Kinshasa</option>
						<option value="Africa/Lagos">(GMT+1) Africa/Lagos</option>
						<option value="Africa/Libreville">(GMT+1) Africa/Libreville</option>
						<option value="Africa/Luanda">(GMT+1) Africa/Luanda</option>
						<option value="Africa/Malabo">(GMT+1) Africa/Malabo</option>
						<option value="Africa/Ndjamena">(GMT+1) Africa/Ndjamena</option>
						<option value="Africa/Niamey">(GMT+1) Africa/Niamey</option>
						<option value="Africa/Porto-Novo">(GMT+1) Africa/Porto-Novo</option>
						<option value="Africa/Tunis">(GMT+1) Africa/Tunis</option>
						<option value="Africa/Windhoek">(GMT+1) Africa/Windhoek</option>
						<option value="Europe/Amsterdam">(GMT+1) Europe/Amsterdam</option>
						<option value="Europe/Andorra">(GMT+1) Europe/Andorra</option>
						<option value="Europe/Belgrade">(GMT+1) Europe/Belgrade</option>
						<option value="Europe/Berlin">(GMT+1) Europe/Berlin</option>
						<option value="Europe/Bratislava">(GMT+1) Europe/Bratislava</option>
						<option value="Europe/Brussels">(GMT+1) Europe/Brussels</option>
						<option value="Europe/Budapest">(GMT+1) Europe/Budapest</option>
						<option value="Europe/Copenhagen">(GMT+1) Europe/Copenhagen</option>
						<option value="Europe/Gibraltar">(GMT+1) Europe/Gibraltar</option>
						<option value="Europe/Ljubljana">(GMT+1) Europe/Ljubljana</option>
						<option value="Europe/Luxembourg">(GMT+1) Europe/Luxembourg</option>
						<option value="Europe/Madrid">(GMT+1) Europe/Madrid</option>
						<option value="Europe/Malta">(GMT+1) Europe/Malta</option>
						<option value="Europe/Monaco">(GMT+1) Europe/Monaco</option>
						<option value="Europe/Oslo">(GMT+1) Europe/Oslo</option>
						<option value="Europe/Paris">(GMT+1) Europe/Paris</option>
						<option value="Europe/Podgorica">(GMT+1) Europe/Podgorica</option>
						<option value="Europe/Prague">(GMT+1) Europe/Prague</option>
						<option value="Europe/Rome">(GMT+1) Europe/Rome</option>
						<option value="Europe/San_Marino">(GMT+1) Europe/San_Marino</option>
						<option value="Europe/Sarajevo">(GMT+1) Europe/Sarajevo</option>
						<option value="Europe/Skopje">(GMT+1) Europe/Skopje</option>
						<option value="Europe/Stockholm">(GMT+1) Europe/Stockholm</option>
						<option value="Europe/Tirane">(GMT+1) Europe/Tirane</option>
						<option value="Europe/Vaduz">(GMT+1) Europe/Vaduz</option>
						<option value="Europe/Vatican">(GMT+1) Europe/Vatican</option>
						<option value="Europe/Vienna">(GMT+1) Europe/Vienna</option>
						<option value="Europe/Warsaw">(GMT+1) Europe/Warsaw</option>
						<option value="Europe/Zagreb">(GMT+1) Europe/Zagreb</option>
						<option value="Europe/Zurich">(GMT+1) Europe/Zurich</option>
						<option value="Africa/Blantyre">(GMT+2) Africa/Blantyre</option>
						<option value="Africa/Bujumbura">(GMT+2) Africa/Bujumbura</option>
						<option value="Africa/Cairo">(GMT+2) Africa/Cairo</option>
						<option value="Africa/Gaborone">(GMT+2) Africa/Gaborone</option>
						<option value="Africa/Harare">(GMT+2) Africa/Harare</option>
						<option value="Africa/Johannesburg">(GMT+2) Africa/Johannesburg</option>
						<option value="Africa/Kigali">(GMT+2) Africa/Kigali</option>
						<option value="Africa/Lubumbashi">(GMT+2) Africa/Lubumbashi</option>
						<option value="Africa/Lusaka">(GMT+2) Africa/Lusaka</option>
						<option value="Africa/Maputo">(GMT+2) Africa/Maputo</option>
						<option value="Africa/Maseru">(GMT+2) Africa/Maseru</option>
						<option value="Africa/Mbabane">(GMT+2) Africa/Mbabane</option>
						<option value="Africa/Tripoli">(GMT+2) Africa/Tripoli</option>
						<option value="Asia/Amman">(GMT+2) Asia/Amman</option>
						<option value="Asia/Beirut">(GMT+2) Asia/Beirut</option>
						<option value="Asia/Damascus">(GMT+2) Asia/Damascus</option>
						<option value="Asia/Gaza">(GMT+2) Asia/Gaza</option>
						<option value="Asia/Hebron">(GMT+2) Asia/Hebron</option>
						<option value="Asia/Jerusalem">(GMT+2) Asia/Jerusalem</option>
						<option value="Asia/Nicosia">(GMT+2) Asia/Nicosia</option>
						<option value="Europe/Athens">(GMT+2) Europe/Athens</option>
						<option value="Europe/Bucharest">(GMT+2) Europe/Bucharest</option>
						<option value="Europe/Chisinau">(GMT+2) Europe/Chisinau</option>
						<option value="Europe/Helsinki">(GMT+2) Europe/Helsinki</option>
						<option value="Europe/Istanbul">(GMT+2) Europe/Istanbul</option>
						<option value="Europe/Kiev">(GMT+2) Europe/Kiev</option>
						<option value="Europe/Mariehamn">(GMT+2) Europe/Mariehamn</option>
						<option value="Europe/Riga">(GMT+2) Europe/Riga</option>
						<option value="Europe/Simferopol">(GMT+2) Europe/Simferopol</option>
						<option value="Europe/Sofia">(GMT+2) Europe/Sofia</option>
						<option value="Europe/Tallinn">(GMT+2) Europe/Tallinn</option>
						<option value="Europe/Uzhgorod">(GMT+2) Europe/Uzhgorod</option>
						<option value="Europe/Vilnius">(GMT+2) Europe/Vilnius</option>
						<option value="Europe/Zaporozhye">(GMT+2) Europe/Zaporozhye</option>
						<option value="Africa/Addis_Ababa">(GMT+3) Africa/Addis_Ababa</option>
						<option value="Africa/Asmara">(GMT+3) Africa/Asmara</option>
						<option value="Africa/Dar_es_Salaam">(GMT+3) Africa/Dar_es_Salaam</option>
						<option value="Africa/Djibouti">(GMT+3) Africa/Djibouti</option>
						<option value="Africa/Juba">(GMT+3) Africa/Juba</option>
						<option value="Africa/Kampala">(GMT+3) Africa/Kampala</option>
						<option value="Africa/Khartoum">(GMT+3) Africa/Khartoum</option>
						<option value="Africa/Mogadishu">(GMT+3) Africa/Mogadishu</option>
						<option value="Africa/Nairobi">(GMT+3) Africa/Nairobi</option>
						<option value="Antarctica/Syowa">(GMT+3) Antarctica/Syowa</option>
						<option value="Asia/Aden">(GMT+3) Asia/Aden</option>
						<option value="Asia/Baghdad">(GMT+3) Asia/Baghdad</option>
						<option value="Asia/Bahrain">(GMT+3) Asia/Bahrain</option>
						<option value="Asia/Kuwait">(GMT+3) Asia/Kuwait</option>
						<option value="Asia/Qatar">(GMT+3) Asia/Qatar</option>
						<option value="Asia/Riyadh">(GMT+3) Asia/Riyadh</option>
						<option value="Europe/Kaliningrad">(GMT+3) Europe/Kaliningrad</option>
						<option value="Europe/Minsk">(GMT+3) Europe/Minsk</option>
						<option value="Indian/Antananarivo">(GMT+3) Indian/Antananarivo</option>
						<option value="Indian/Comoro">(GMT+3) Indian/Comoro</option>
						<option value="Indian/Mayotte">(GMT+3) Indian/Mayotte</option>
						<option value="Asia/Tehran">(GMT+3.5) Asia/Tehran</option>
						<option value="Asia/Baku">(GMT+4) Asia/Baku</option>
						<option value="Asia/Dubai">(GMT+4) Asia/Dubai</option>
						<option value="Asia/Muscat">(GMT+4) Asia/Muscat</option>
						<option value="Asia/Tbilisi">(GMT+4) Asia/Tbilisi</option>
						<option value="Asia/Yerevan">(GMT+4) Asia/Yerevan</option>
						<option value="Europe/Moscow">(GMT+4) Europe/Moscow</option>
						<option value="Europe/Samara">(GMT+4) Europe/Samara</option>
						<option value="Europe/Volgograd">(GMT+4) Europe/Volgograd</option>
						<option value="Indian/Mahe">(GMT+4) Indian/Mahe</option>
						<option value="Indian/Mauritius">(GMT+4) Indian/Mauritius</option>
						<option value="Indian/Reunion">(GMT+4) Indian/Reunion</option>
						<option value="Asia/Kabul">(GMT+4.5) Asia/Kabul</option>
						<option value="Antarctica/Mawson">(GMT+5) Antarctica/Mawson</option>
						<option value="Asia/Aqtau">(GMT+5) Asia/Aqtau</option>
						<option value="Asia/Aqtobe">(GMT+5) Asia/Aqtobe</option>
						<option value="Asia/Ashgabat">(GMT+5) Asia/Ashgabat</option>
						<option value="Asia/Dushanbe">(GMT+5) Asia/Dushanbe</option>
						<option value="Asia/Karachi">(GMT+5) Asia/Karachi</option>
						<option value="Asia/Oral">(GMT+5) Asia/Oral</option>
						<option value="Asia/Samarkand">(GMT+5) Asia/Samarkand</option>
						<option value="Asia/Tashkent">(GMT+5) Asia/Tashkent</option>
						<option value="Indian/Kerguelen">(GMT+5) Indian/Kerguelen</option>
						<option value="Indian/Maldives">(GMT+5) Indian/Maldives</option>
						<option value="Asia/Colombo">(GMT+5.5) Asia/Colombo</option>
						<option value="Asia/Kolkata">(GMT+5.5) Asia/Kolkata</option>
						<option value="Asia/Kathmandu">(GMT+5.75) Asia/Kathmandu</option>
						<option value="Antarctica/Vostok">(GMT+6) Antarctica/Vostok</option>
						<option value="Asia/Almaty">(GMT+6) Asia/Almaty</option>
						<option value="Asia/Bishkek">(GMT+6) Asia/Bishkek</option>
						<option value="Asia/Dhaka">(GMT+6) Asia/Dhaka</option>
						<option value="Asia/Qyzylorda">(GMT+6) Asia/Qyzylorda</option>
						<option value="Asia/Thimphu">(GMT+6) Asia/Thimphu</option>
						<option value="Asia/Yekaterinburg">(GMT+6) Asia/Yekaterinburg</option>
						<option value="Indian/Chagos">(GMT+6) Indian/Chagos</option>
						<option value="Asia/Rangoon">(GMT+6.5) Asia/Rangoon</option>
						<option value="Indian/Cocos">(GMT+6.5) Indian/Cocos</option>
						<option value="Antarctica/Davis">(GMT+7) Antarctica/Davis</option>
						<option value="Asia/Bangkok">(GMT+7) Asia/Bangkok</option>
						<option value="Asia/Ho_Chi_Minh">(GMT+7) Asia/Ho_Chi_Minh</option>
						<option value="Asia/Hovd">(GMT+7) Asia/Hovd</option>
						<option value="Asia/Jakarta">(GMT+7) Asia/Jakarta</option>
						<option value="Asia/Novokuznetsk">(GMT+7) Asia/Novokuznetsk</option>
						<option value="Asia/Novosibirsk">(GMT+7) Asia/Novosibirsk</option>
						<option value="Asia/Omsk">(GMT+7) Asia/Omsk</option>
						<option value="Asia/Phnom_Penh">(GMT+7) Asia/Phnom_Penh</option>
						<option value="Asia/Pontianak">(GMT+7) Asia/Pontianak</option>
						<option value="Asia/Vientiane">(GMT+7) Asia/Vientiane</option>
						<option value="Indian/Christmas">(GMT+7) Indian/Christmas</option>
						<option value="Antarctica/Casey">(GMT+8) Antarctica/Casey</option>
						<option value="Asia/Brunei">(GMT+8) Asia/Brunei</option>
						<option value="Asia/Choibalsan">(GMT+8) Asia/Choibalsan</option>
						<option value="Asia/Chongqing">(GMT+8) Asia/Chongqing</option>
						<option value="Asia/Harbin">(GMT+8) Asia/Harbin</option>
						<option value="Asia/Hong_Kong">(GMT+8) Asia/Hong_Kong</option>
						<option value="Asia/Kashgar">(GMT+8) Asia/Kashgar</option>
						<option value="Asia/Krasnoyarsk">(GMT+8) Asia/Krasnoyarsk</option>
						<option value="Asia/Kuala_Lumpur">(GMT+8) Asia/Kuala_Lumpur</option>
						<option value="Asia/Kuching">(GMT+8) Asia/Kuching</option>
						<option value="Asia/Macau">(GMT+8) Asia/Macau</option>
						<option value="Asia/Makassar">(GMT+8) Asia/Makassar</option>
						<option value="Asia/Manila">(GMT+8) Asia/Manila</option>
						<option value="Asia/Shanghai">(GMT+8) Asia/Shanghai</option>
						<option value="Asia/Singapore">(GMT+8) Asia/Singapore</option>
						<option value="Asia/Taipei">(GMT+8) Asia/Taipei</option>
						<option value="Asia/Ulaanbaatar">(GMT+8) Asia/Ulaanbaatar</option>
						<option value="Asia/Urumqi">(GMT+8) Asia/Urumqi</option>
						<option value="Australia/Perth">(GMT+8) Australia/Perth</option>
						<option value="Australia/Eucla">(GMT+8.75) Australia/Eucla</option>
						<option value="Asia/Dili">(GMT+9) Asia/Dili</option>
						<option value="Asia/Irkutsk">(GMT+9) Asia/Irkutsk</option>
						<option value="Asia/Jayapura">(GMT+9) Asia/Jayapura</option>
						<option value="Asia/Pyongyang">(GMT+9) Asia/Pyongyang</option>
						<option value="Asia/Seoul">(GMT+9) Asia/Seoul</option>
						<option value="Asia/Tokyo">(GMT+9) Asia/Tokyo</option>
						<option value="Pacific/Palau">(GMT+9) Pacific/Palau</option>
						<option value="Australia/Adelaide">(GMT+9.5) Australia/Adelaide</option>
						<option value="Australia/Broken_Hill">(GMT+9.5) Australia/Broken_Hill</option>
						<option value="Australia/Darwin">(GMT+9.5) Australia/Darwin</option>
						<option value="Antarctica/DumontDUrville">(GMT+10) Antarctica/DumontDUrville</option>
						<option value="Asia/Yakutsk">(GMT+10) Asia/Yakutsk</option>
						<option value="Australia/Brisbane">(GMT+10) Australia/Brisbane</option>
						<option value="Australia/Currie">(GMT+10) Australia/Currie</option>
						<option value="Australia/Hobart">(GMT+10) Australia/Hobart</option>
						<option value="Australia/Lindeman">(GMT+10) Australia/Lindeman</option>
						<option value="Australia/Melbourne">(GMT+10) Australia/Melbourne</option>
						<option value="Australia/Sydney">(GMT+10) Australia/Sydney</option>
						<option value="Pacific/Chuuk">(GMT+10) Pacific/Chuuk</option>
						<option value="Pacific/Guam">(GMT+10) Pacific/Guam</option>
						<option value="Pacific/Port_Moresby">(GMT+10) Pacific/Port_Moresby</option>
						<option value="Pacific/Saipan">(GMT+10) Pacific/Saipan</option>
						<option value="Australia/Lord_Howe">(GMT+10.5) Australia/Lord_Howe</option>
						<option value="Antarctica/Macquarie">(GMT+11) Antarctica/Macquarie</option>
						<option value="Asia/Sakhalin">(GMT+11) Asia/Sakhalin</option>
						<option value="Asia/Vladivostok">(GMT+11) Asia/Vladivostok</option>
						<option value="Pacific/Efate">(GMT+11) Pacific/Efate</option>
						<option value="Pacific/Guadalcanal">(GMT+11) Pacific/Guadalcanal</option>
						<option value="Pacific/Kosrae">(GMT+11) Pacific/Kosrae</option>
						<option value="Pacific/Noumea">(GMT+11) Pacific/Noumea</option>
						<option value="Pacific/Pohnpei">(GMT+11) Pacific/Pohnpei</option>
						<option value="Pacific/Norfolk">(GMT+11.5) Pacific/Norfolk</option>
						<option value="Antarctica/McMurdo">(GMT+12) Antarctica/McMurdo</option>
						<option value="Antarctica/South_Pole">(GMT+12) Antarctica/South_Pole</option>
						<option value="Asia/Anadyr">(GMT+12) Asia/Anadyr</option>
						<option value="Asia/Kamchatka">(GMT+12) Asia/Kamchatka</option>
						<option value="Asia/Magadan">(GMT+12) Asia/Magadan</option>
						<option value="Pacific/Auckland">(GMT+12) Pacific/Auckland</option>
						<option value="Pacific/Fiji">(GMT+12) Pacific/Fiji</option>
						<option value="Pacific/Funafuti">(GMT+12) Pacific/Funafuti</option>
						<option value="Pacific/Kwajalein">(GMT+12) Pacific/Kwajalein</option>
						<option value="Pacific/Majuro">(GMT+12) Pacific/Majuro</option>
						<option value="Pacific/Nauru">(GMT+12) Pacific/Nauru</option>
						<option value="Pacific/Tarawa">(GMT+12) Pacific/Tarawa</option>
						<option value="Pacific/Wake">(GMT+12) Pacific/Wake</option>
						<option value="Pacific/Wallis">(GMT+12) Pacific/Wallis</option>
						<option value="Pacific/Chatham">(GMT+12.75) Pacific/Chatham</option>
						<option value="Pacific/Apia">(GMT+13) Pacific/Apia</option>
						<option value="Pacific/Enderbury">(GMT+13) Pacific/Enderbury</option>
						<option value="Pacific/Fakaofo">(GMT+13) Pacific/Fakaofo</option>
						<option value="Pacific/Tongatapu">(GMT+13) Pacific/Tongatapu</option>
						<option value="Pacific/Kiritimati">(GMT+14) Pacific/Kiritimati</option>
					</select>
				</div>
				<hr />
				<div>
					<button type="submit" id="personaldetails" name="personaldetails"
						class="btn btn-save">SAVE ACCOUNT CHANGES</button>
				</div>

			</div>

		</div>

		<div id="mplans" class="tabcontent">

			<div class="tab-container">
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-2"></div>
					<div class="col-sm-2">
						<p style="font-weight: 100">
							<strong
								style="color: #3c3f42; font-weight: 100; margin-left: 14%; font-size: 24px;">Basic</strong><br>
							<strong
								style="color: #005476; font-size: 32px; padding-top: 5px; margin-left: 11%;">Free</strong>
						</p>
					</div>

					<div class="col-sm-4">
						<p style="font-weight: 100">
							<strong
								style="color: #3c3f42; font-weight: 100; margin-left: 50%; font-size: 24px;">Pro</strong><br>
							<strong
								style="color: #005476; font-size: 32px; padding-top: 5px; margin-left: 40%;">$16.67
								<sup>*</sup><sub style="font-size: 1.3rem;">p/m</sub>
							</strong>
						</p>
						<p style="font-size: 12px; color: #343333de; left: 2%;">Billed
							annually. Annual cost $200.</p>
					</div>
				</div>
				<br>
				<br>
				<div class="row">
					<table class="plan-table">
						<tbody>
						<colgroup>
							<col span="1" style="background-color: #f7f7f7;">
							<col span="2" style="background-color: #e5eaef;">
						</colgroup>
						<tr>
							<td>Mobile platform</td>
							<td><i class="fa fa-close"
								style="font-size: 24px; color: red"></i></td>
							<td><i class="fa fa-check"
								style="font-size: 24px; color: #28a745"></i></td>
						</tr>
						<tr>
							<td>Platform support</td>
							<td><i class="fa fa-close"
								style="font-size: 24px; color: red"></i></td>
							<td><i class="fa fa-check"
								style="font-size: 24px; color: #28a745"></i></td>
						</tr>
						<tr>
							<td>Ad Free</td>
							<td><i class="fa fa-close"
								style="font-size: 24px; color: red"></i></td>
							<td><i class="fa fa-check"
								style="font-size: 24px; color: #28a745"></i></td>
						</tr>
						</tbody>
					</table>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-4"></div>
					<div class="col-sm-2"></div>
					<div class="col-sm-2">
						<input type="button" name="" value="Choose Plan"
							class="btn btn-success">
					</div>

					<div class="col-sm-4">
						<input type="button" name="" value="Choose Plan(Annually)"
							class="btn btn-success" style="margin-left: 27%;">
					</div>

				</div>

			</div>
		</div>

		<div id="settings" class="tabcontent general-form">
			<div class="tab-container">
				<h2>Change Password</h2>
				<br>
				<br>
				<div>
					<label for="clientaccount_pwd">New Password</label> <input
						type="password" id="clientaccount_Newpwd"
						name="clientaccount_Newpwd">
				</div>
				<div>
					<label for="clientaccount_Confirmpwd">Confirm Password</label> <input
						type="password" id="clientaccount_cnfpwd"
						name="clientaccount_cnfpwd">
				</div>
				<hr />
				<div>
					<button type="submit" id="changepassword" name="changepassword"
						class="btn btn-save">CHANGE PASSWORD</button>
				</div>
			</div>
		</div>
	</div>
	  
   <!-- The Modal -->
<div id="myModal" class="modal">
  <!-- Modal content -->
  <div class="modal-content close-button-div">
  	    <span class="close">&times;</span>
   </div>
 <div class="modal-content content-div" style="font-size:1.0rem;background-color:#ffffff;">
    <p>Your password has been successfully updated</p>
   <input type="button" class="btn btn-default" value="Click Here to Proceed" onclick="redirectMyProfile();">
  </div>
 </div> 

	<div id="pmyModal" class="modal">
  <!-- Modal content -->
  <div class="modal-content close-button-div">
  	    <span class="close">&times;</span>
   </div>
 <div class="modal-content content-div" style="font-size:1.0rem;background-color:#ffffff;">
    <p>Your personal details has been successfully updated</p>
   <input type="button" class="btn btn-default" value="Click Here to Proceed" onclick="redirectMyPersonalInfo();">
  </div>
 </div> 
	
	<div class="loader-div">
		<img src="${pageContext.request.contextPath}/static/Images/35.gif" width="45" height="45">
	</div> 
	<script>

/* Change Password Function */
$("#changepassword").click(function(e) {
			
	$("#changepassword").attr("disabled", true);
	$(".loader-div").show();
	
	
	var changePasswordDetails = {
			
			'clientaccount_Newpwd' : $("#clientaccount_Newpwd").val(),
			'clientaccount_cnfpwd' : $("#clientaccount_cnfpwd").val()
		}
	
	
	$.ajax({
		url : 'changePassword',
		type : 'POST',
		data : buildQuery(changePasswordDetails),
		success : function(result) {
			if (result === "success") {
				$(".loader-div").hide();
				onClickAlertBox();
				//alert("Successfully changed the password");
			//window.location.href="myProfile.html";
			} else {
				$(".loader-div").hide();
				alert("Sorry,an error occured while changing the password.");
				window.location.href="error.html";

			
			}
		}
	}); 
});

function openPage(pageName,elmnt,color) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
        

    }
    document.getElementById(pageName).style.display = "block";
    elmnt.style.backgroundColor = color;

}
// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();

/* REGISTRATION FUNCTION */
$("#personaldetails").click(function(e) {
	
	//alert("personaldetails");
	//debugger;
			
	$("#personaldetails").attr("disabled", true);
	$(".loader-div").show();

	var personalDetails = {

		'clientaccount_name' : $("#clientaccount_name").val(),
		'clientaccount_lname' : $("#clientaccount_lname").val(),
		'clientaccount_email' : $("#clientaccount_email").val(),
		'clientaccount_company_name' : $("#clientaccount_company_name").val(),
		'clientaccount_job_title':$("#clientaccount_job_title").val(),
		'clientaccount_website':$("#clientaccount_website").val(),
		'clientaccount_timezone':$("#clientaccount_timezone").val(),
		'socialserver_corebundle_clientaccount_country':$("#socialserver_corebundle_clientaccount_country").val()

	}
	//alert(personalDetails); 
	
	$.ajax({
		url : 'personalInfo',
		type : 'POST',
		data : buildQuery(personalDetails),
		success : function(result) {

			if (result === "success") {
				$(".loader-div").hide();
				//alert("We have sent a mail on your registered Id.Please verify it to proceed for Login ");
				onClickAlertBoxForPersonalInfo();
			} else {
				$(".loader-div").hide();
				alert("Sorry,an error occured while not register.");
				window.location.href="error.html";
			
			}
		}
	});
	
});

function buildQuery(obj) {
	var Result = '';
	if (typeof (obj) == 'object') {
		jQuery.each(obj, function(key, value) {
			Result += (Result) ? '&' : '';
			if (typeof (value) == 'object' && value.length) {
				for (var i = 0; i < value.length; i++) {
					Result += [ key + '[]', encodeURIComponent(value[i]) ].join('=');
				}
			} else {
				Result += [ key, encodeURIComponent(value) ].join('=');
			}
		});
	}
	return Result;
	}

function redirectMyProfile(){
window.location.href="${pageContext.request.contextPath}/myProfileDetails?email=${emailId}&&userName=${username}";
}

function redirectMyPersonalInfo(){
	window.location.href="${pageContext.request.contextPath}/myProfileDetails?email=${emailId}&&userName=${username}";
}
function onClickAlertBoxForPersonalInfo(){
	   // alert("registration successful");
		var modal = document.getElementById('pmyModal');
		// Get the button that opens the modal
		var btn = document.getElementById("pmyBtn");
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("pclose")[0];
		// When the user clicks the button, open the modal 

		  document.getElementById("pmyModal").style.display = "block";

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		    modal.style.display = "none";
		}
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
	}

 
</script>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
