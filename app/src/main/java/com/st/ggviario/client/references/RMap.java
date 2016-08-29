package com.st.ggviario.client.references;

public interface RMap
{
	/**
	 * A porta de cuminicacao é gege {g = 7 | e = 5}
	 */
	int SOCKET_PORT = 7575;

	//IDENTIFICADORES
	String IDENTIFIER_SELL_MEASURE = "IDENTIFIER_SELL_MEASURE";
	String IDENTIFIER_SELL = "IDENTIFIER_SELL";
	String IDENTIFIER_SELL_PRODUCT = "IDENTIFIER_SELL_PRODUCT";
	String IDENTIFIER_SELL_PRINCIPAL = "IDENTIFIER_SELL_PRINCIPAL";
	String IDENTIFIER_SELL_PAYMENT = "IDENTIFIER_SELL_PAYMENT";
	String IDENTIFIER_SELL_SUPPORT = "IDENTIFIER_SELL_SUPPORT";
	String IDENTIFIER_SELL_PAY_NOW = "IDENTIFIER_SELL_PAY_NOW";
	String IDENTIFIER_SELL_PAY_CREDIT = "IDENTIFIER_SELL_PAY_CREDIT";
	String IDENTIFIER_SELL_CLIENT_ITEM = "IDENTIFIER_SELL_CLIENT_ITEM";
	String IDENTIFIER_SELL_CLIENT_SUPPORT = "IDENTIFIER_SELL_CLIENT_SUPPORT";
	String IDENTIFIER_SELL_CLIENT_LIST = "IDENTIFIER_SELL_CLIENT_LIST";
	String IDENTIFIER_SELL_CLIENT_REGISTER = "IDENTIFIER_SELL_CLIENT_REGISTER";
	String IDENTIFIER_SELL_HOME = "IDENTIFIER_SELL_HOME";
	String IDENTIFIER_SELL_HOME_OPERATIONS = "IDENTIFIER_SELL_HOME_OPERATIONS";
	String IDENTIFIER_SELL_SUMMARY = "IDENTIFIER_SELL_SUMMARY";
	String IDENTIFIER_GGVIARIO = "IDENTIFIER_GGVIARIO";
	String IDENTIFIER_INIT_SYNC = "IDENTIFIER_INIT_SYNC";
	String IDENTIFIER_SYNCHRONISE = "IDENTIFIER_SYNCHRONISE";
	String IDENTIFIER_SYNC_UPPLOAD = "IDENTIFIER_SYNC_UPPLOAD";
	String IDENTIFIER_MAIN_HOME = "IDENTIFIER_MAIN_HOME";

	//QUERY FROM SERVER TO CLIENTS
	String QUERY_DATA_CREATOR = "QUERY_DATA_CREATOR";
	String QUERY_LIST_PRODUCTS = "QUERY_LIST_PRODUCTS";
	String QUERY_CLIENT_SELECTED = "QUERY_CLIENT_SELECTED";
	String QUERY_GET_SOCKET_SERVICE = "QUERY_GET_SOCKET_SERVICE";
	
	//RESPONSES
	String RESPONSE_SELECTED = "RESPONSE_SELECTED";


	//SUMARYES
	String SUMMARY_NOTIFY = "SUMM_NOTIFY_CHANGE";
	String SUMMARY_MEASURE_CHANGE_STATE = "SUMM_CHANGE_SATATE";
	String SUMMARY_PRICE_CALCULATED = "SUMMARY_PRICE_CALCULATED";
	String SUMMARY_SHOW_BOTTOM_PAY = "SUMMARY_SHOW_BOTTOM_PAY";
	String SUMMARY_HIDDEN_BOTTOM_PAY = "SUMMARY_HIDDEN_BOTTOM_PAY";
	String SUMMARY_NAVE_MY = "SUMMARY_NAVE_MY";
	String SUMMARY_REGISTER_SELL_NOW = "SUMMARY_REGISTER_SELL_NOW";
	String SUMMARY_REGISTER_PAYMENT_CREDIT = "SUMMARY_REGISTER_PAYMENT_CREDIT" ;
	String SUMMARY_NEXT_SEEP = "SUMMARY_NEXT_SEEP";
	String SUMMARY_NEW_REGISTER_SUCCESS = "SUMMARY_NEW_REGISTER_SUCCESS";
	String SUMMARY_NAVE_PAGER = "SUMMARY_NAVE_PAGER";
	String SUMMARY_OPEN_DRAWER = "SUMMARY_OPEN_DRAWER";
	String SUMMARY_CHANGE_LIST = "SUMMARY_CHANGE_LIST";
	String SUMMARY_UPDATE_VIEW = "SUMMARY_UPDATE_VIEW";
	String SUMMARY_PRODUCT_CHAGE = "SUMMARY_PRODUCT_CHAGE";
	String SUMMARY_CLIENT_CHANGED = "SUMMARY_CLIENT_CHANGED";
	String SUMMARY_CLIENT_CLICKED = "SUMMARY_CLIENT_CLICKED";
	String SUMMARY_REGISTER_TREATER_LISTNER = "SUMMARY_REGISTER_TREATER_LISTNER";;
}