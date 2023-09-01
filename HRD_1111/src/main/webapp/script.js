 function check(){
		var f = document.frm;
		var v_jumin = f.v_jumin.value;
		var v_name = f.v_name.value;
		var m_no = f.m_no.value;
		var v_time = f.v_time.value;
		var v_area = f.v_area.value;
		var v_confirm = f.v_confirm.value;
		var jumin = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/;
		if(v_jumin == ""){
			alert("주민번호가 입력되지 않았습니다!");
			f.v_jumin.focus();
			return false;
		}else if(!jumin.test(v_jumin) || v_jumin.length <13 || v_jumin.length >13){
			alert("유효하지않은 주민번호 입니다.\n 숫자 13자리로 입력해주세요.");
			f.v_jumin.focus(); 
			return false;
		}else if(v_name == ""){
			alert("성명이 입력되지 않았습니다!")
			f.v_name.focus();
			return false;
		}else if(m_no == ""){
			alert("후보번호가 선택되지 않았습니다!")
			m_no.focus();
			return false;
		}else if(v_time == ""){
			alert("투표시간이 입력되지 않았습니다!")
			v_time.focus();
			return false;
		}else if(v_area == ""){
			alert("투표장소가 입력되지 않았습니다!")
			v_area.focus();
			return false;
		}else if(v_confirm == ""){
			alert("유권자확인이 선택되지 않았습니다!")
			v_confirm.focus();
			return false;
		}else{
			alert("정상적으로 등록 되었습니다")
			f.submit();
		}
	}
	
	function fn_reset(){
			alert("정보를 지우고 처음부터 다시 입력합니다!");
			location="TestServlet?command=insertview";
		}
		
	function fn_onload(){
		document.frm.v_jumin.focus();
		document.frm.onload();
	}