<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >

<xsl:template match="/">
<html>
	<head>
	<title>Statement</title>
	<link rel='stylesheet' href="style.css"></link>
	</head>
	<body>
	   <xsl:apply-templates select="MunicipalStatement"/>
    </body>
</html>
</xsl:template>



	<xsl:template match="MunicipalStatement">
	
		<header>
			<h1>Statement</h1>
			
		</header>
			<h1>Recipient</h1>
			<p>Account Holder Name <p><xsl:value-of select="AccountHolderName"/></p></p><br/>
			<p>Account Number<p><xsl:value-of select="AccountNumber"/></p></p>
			
			<table class="meta">
				<tr>
					<th><span >Invoice Number</span></th>
					<td><span ><xsl:value-of select="AccountStatementNumber"/></span></td>
				</tr>
				<tr>
					<th><span >Account Statement Month</span></th>
					<td><span ><xsl:value-of select="AccountStatementMonth"/></span></td>
				</tr>
				<tr>
					<th><span >Account Total Due</span></th>
					<td><span id="prefix">$</span><span><xsl:value-of select="AccountTotalDue"/></span></td>
				</tr>
			</table>
			<table class="inventory">
				<thead>
					<tr>
						<th><span>Item</span></th>
						<th><span>Rate</span></th>
						<th><span>Price</span></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><a class="cut">-</a><span>ElectricityUsed</span></td>
						<td><span><xsl:value-of select="ElectricityUsed"/></span></td>
						<td><span>R</span><span><xsl:value-of select="ElectricityCharges"/></span></td>
					</tr>
					<tr>
						<td><a class="cut">-</a><span>GasUsed</span></td>
						<td><span><xsl:value-of select="GasUsed"/></span></td>
						<td><span>R</span><span><xsl:value-of select="GasCharges"/></span></td>
					</tr>
					<tr>
						<td><a class="cut">-</a><span>WaterUsed</span></td>
						<td><span><xsl:value-of select="WaterUsed"/></span></td>
						<td><span>R</span><span><xsl:value-of select="WaterCharges"/></span></td>
					</tr>
					<tr>
						<td><a class="cut">-</a><span>SewerageCharges</span></td>
						<td><span></span></td>
						<td><span>R</span><span><xsl:value-of select="SewerageCharges"/></span></td>
					</tr>
					<tr>
						<td><a class="cut">-</a><span>RefuseCharges</span></td>
						<td><span></span></td>
						<td><span></span><span></span></td>
					</tr>
				</tbody>
			</table>
			<a class="add">+</a>
			<table class="balance">
				<tr>
					<th><span>Total</span></th>
					<td><span>R</span><span>600.00</span></td>
				</tr>
				<tr>
					<th><span>AccountPaymentReceived</span></th>
					<td><span>R</span><span><xsl:value-of select="AccountPaymentReceived"/></span></td>
				</tr>
				<tr>
					<th><span>Balance Due</span></th>
					<td><span>R</span><span>600.00</span></td>
				</tr>
				<tr>
					<th><span>Vat @ 14%</span></th>
					<td><span>R</span><span><xsl:value-of select="AccountVATAmount"/></span></td>
				</tr>
				<tr>
					<th><span>Grand Total</span></th>
					<td><span>R</span><span><xsl:value-of select="AccountClosingBalance"/></span></td>
				</tr>
			</table>
		
		<aside>
			<h1><span>Additional Notes</span></h1>
			<div>
				<p>Account Due Date: <xsl:value-of select="AccountDueDate"/></p>
			</div>
			<div>
				<p>Installment Notice: <xsl:value-of select="InstalmentNotice"/></p>
			</div>
		</aside>
     </xsl:template>
</xsl:stylesheet>		