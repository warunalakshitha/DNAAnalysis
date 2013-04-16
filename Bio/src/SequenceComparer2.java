

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.biojava3.alignment.Alignments;
import org.biojava3.alignment.Alignments.PairwiseSequenceAlignerType;
import org.biojava3.alignment.SimpleGapPenalty;
import org.biojava3.alignment.SubstitutionMatrixHelper;
import org.biojava3.alignment.template.PairwiseSequenceAligner;
import org.biojava3.alignment.template.SequencePair;
import org.biojava3.alignment.template.SubstitutionMatrix;
import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.compound.AmbiguityDNACompoundSet;
import org.biojava3.core.sequence.compound.NucleotideCompound;

public class SequenceComparer2 {
    
    
    public static void main(String[] args) throws IOException {
    	System.out.println("START...");

        
//    	String targetSeq = "CACGTTTCTTGTGGCAGCTTAAGTTTGAATGTCATTTCTTCAATGGGACGGA"+
//        "GCGGGTGCGGTTGCTGGAAAGATGCATCTATAACCAAGAGGAGTCCGTGCGCTTCGACAGC"+
//	  "GACGTGGGGGAGTACCGGGCGGTGACGGAGCTGGGGCGGCCTGATGCCGAGTACTGGAACA"+
//	  "GCCAGAAGGACCTCCTGGAGCAGAGGCGGGCCGCGGTGGACACCTACTGCAGACACAACTA"+ 
//	  "CGGGGTTGGTGAGAGCTTCACAGTGCAGCGGCGAG";
    	
    	String targetSeq = "GTAAATTGATTTCGTATTCTGAGAGGCTGCTGCTTAGCGGTAGCCCCTTGGTTTCCGTGGCAACGGAAAAGCGCGGGAATTACAGATAAATTAAAACTGCGACTGCGCGGCGTGAGCTCGCTGAGACTTCCTGGACGGGGGACAGGCTGTGGGGTTT";
DNASequence target = new DNASequence(targetSeq,
		AmbiguityDNACompoundSet.getDNACompoundSet());
String querySeq="";
//File file = new File("C:/Users/Manoj/Downloads/BRCA1_REF.txt");
try {
	BufferedReader br= new BufferedReader(new FileReader("C:/Users/Manoj/Downloads/BRCA1_REF.txt"));
	String line = br.readLine();
	while (line != null)
	{
//	    lines.add(line);
		if(line!=null){
		querySeq +=line;
		}
		line = br.readLine();

		System.out.println(querySeq);

	}
	br.close();
	System.out.println("File readed...");

} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//String querySeq = "ACGAGTGCGTGTTTTCCCGCCTGGTCCCCAGGCCCCCTTTCCGTCCTCAGGAA"+
//	  "GACAGAGGAGGAGCCCCTCGGGCTGCAGGTGGTGGGCGTTGCGGCGGCGGCCGGTTAAGGT"+
//	  "TCCCAGTGCCCGCACCCGGCCCACGGGAGCCCCGGACTGGCGGCGTCACTGTCAGTGTCTT"+
//	  "CTCAGGAGGCCGCCTGTGTGACTGGATCGTTCGTGTCCCCACAGCACGTTTCTTGGAGTAC"+
//	  "TCTACGTCTGAGTGTCATTTCTTCAATGGGACGGAGCGGGTGCGGTTCCTGGACAGATACT"+
//	  "TCCATAACCAGGAGGAGAACGTGCGCTTCGACAGCGACGTGGGGGAGTTCCGGGCGGTGAC"+
//	  "GGAGCTGGGGCGGCCTGATGCCGAGTACTGGAACAGCCAGAAGGACATCCTGGAAGACGAG"+
//	  "CGGGCCGCGGTGGACACCTACTGCAGACACAACTACGGGGTTGTGAGAGCTTCACCGTGCA"+ 
//	  "GCGGCGAGACGCACTCGT";

//String querySeq = "ACGTAT";
DNASequence query = new DNASequence(querySeq,
		AmbiguityDNACompoundSet.getDNACompoundSet());

SubstitutionMatrix<NucleotideCompound> matrix = SubstitutionMatrixHelper.getNuc4_4();

SimpleGapPenalty gapP = new SimpleGapPenalty();
gapP.setOpenPenalty((short)5);
gapP.setExtensionPenalty((short)2);

SequencePair<DNASequence, NucleotideCompound> psa =
		Alignments.getPairwiseAlignment(query, target,
				PairwiseSequenceAlignerType.GLOBAL, gapP, matrix);

PairwiseSequenceAligner<DNASequence, NucleotideCompound> psa2 =
	Alignments.getPairwiseAligner(query, target,
			PairwiseSequenceAlignerType.GLOBAL, gapP, matrix);

System.out.println(psa);

    }
    
}
