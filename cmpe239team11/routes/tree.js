/**
 * New node file
 */

exports.processTree=function (req,res){
	
	var age=req.param('age');
	var menopause = req.param('menopause');
	var agemenarche = req.param('agemenarche');
	var bmi = req.param('bmi');
	var race = req.param('race');
	var rpass = req.param('rpass');
		
	if(age<=39){
		
		if(agemenarche==12 || agemenarche==13){
			
			res.send('YESSSSS due to age menarche');
		}
		else{
				if(bmi>=25 && bmi<=29.99){
					
					res.send('yes due to bmi');
						}
				else{
					res.send('no due to bmi');
					
				}
			}
		
	}
	else{
		if(menopause=='post'){
			res.send('yes due to post menopausal');
		}
		else{
			if(race=='non hispanic'){
				res.send('yesss due to non hispanic latino');	
			}
		}
		
		
		
	}
	console.log(age);
	res.end();
}
